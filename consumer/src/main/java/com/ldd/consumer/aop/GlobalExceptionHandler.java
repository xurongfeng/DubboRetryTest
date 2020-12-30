package com.ldd.consumer.aop;

import com.ldd.consumer.core.exception.ResultBizException;
import com.ldd.consumer.core.exception.ResultCode;
import com.ldd.consumer.core.wrapper.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public HttpResult requestMessageNotReadable(HttpMessageNotReadableException ex) {
        log.warn(requestURI() + "请求消息体错误", ex);
        String code = ResultCode.PARAM_WRONG.getCode();
        return HttpResult.failedResult(code, ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public HttpResult requestMethodNotSupport(HttpMediaTypeNotSupportedException ex) {
        log.warn(requestURI() + "请求Content-Type不支持", ex);
        String code = ResultCode.PARAM_WRONG.getCode();
        return HttpResult.failedResult(code, ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public HttpResult requestMethodNotSupport(HttpRequestMethodNotSupportedException ex) {
        log.warn(requestURI() + "请求method不支持", ex);
        String code = ResultCode.PARAM_WRONG.getCode();
        return HttpResult.failedResult(code, ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public HttpResult bindException(BindException ex) {
        log.warn(requestURI() + "接口参数校验失败", ex);
        String code = ResultCode.PARAM_WRONG.getCode();
        BindingResult bindResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindResult.getFieldErrors();
        String msg = null == fieldErrors ? "" : generateMSG(fieldErrors);
        return HttpResult.failedResult(code, msg);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn(requestURI() + "参数验证失败", e);
        String code = ResultCode.PARAM_WRONG.getCode();
        BindingResult bindResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindResult.getFieldErrors();
        String msg = null == fieldErrors ? "" : generateMSG(fieldErrors);
        return HttpResult.failedResult(code, msg);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServletRequestBindingException.class)
    public HttpResult handleServletRequestBindingException(ServletRequestBindingException e) {
        String errorMsg = e.getMessage();
        String url = requestURI();
        if (Objects.nonNull(url) && url.contains("isManager")) {
            log.warn(url + "用户登录信息缺失");
            return HttpResult.failedResult(ResultCode.TOKEN_ERROR.getCode(), errorMsg);
        }
        log.warn(url + "参数验证失败", e);
        return HttpResult.failedResult(ResultCode.PARAM_WRONG.getCode(), errorMsg);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public HttpResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.warn(requestURI() + "参数错误", ex);
        return HttpResult.failedResult(ResultCode.PARAM_WRONG.getCode(), "缺少必要参数,参数名称为" + ex.getParameterName());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public HttpResult handlerException(HttpServletResponse rsp, Exception ex) {
        log.error(requestURI() + "系统发生异常", ex);
        if (ex instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            rsp.setStatus(HttpStatus.NOT_FOUND.value());
            return new HttpResult(ResultCode.NOT_FOUND);
        }
        rsp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new HttpResult<>(ResultCode.ERROR_SYSTEM);
    }



    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = ResultBizException.class)
    public HttpResult handlerException(ResultBizException ex) {
        log.error("系统发生异常", ex);
        return new HttpResult<>(ex.getCode());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = RuntimeException.class)
    public HttpResult handlerException(RuntimeException ex) {
        log.error("系统发生异常", ex);
        return new HttpResult<>("10001", null, ex.getMessage());
    }


    private String generateMSG(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (FieldError error : fieldErrors) {
            sb.append(error.getField()).append(":").append(error.getDefaultMessage()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    private String requestURI() {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            return request.getRequestURI();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}
