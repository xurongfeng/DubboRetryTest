package com.ldd.consumer.core.wrapper;

import com.ldd.consumer.core.exception.ResultCode;
import com.ldd.consumer.core.model.Result;
import com.ldd.consumer.core.transfer.VoTransfer;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class HttpResult<T> implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -873736659882836986L;

  private String code;

  private T result;

  private String errorMsg;

  private boolean isSuccess = true;

  @SuppressWarnings("unchecked")
  public HttpResult() {
    result = null;
    this.code = ResultCode.NORMAL.getCode();
    this.errorMsg = ResultCode.NORMAL.getMsg();
  }

  public HttpResult(ResultCode resultCode) {
    if (resultCode == null) {
      this.code = ResultCode.ERROR_SYSTEM.getCode();
      this.errorMsg = ResultCode.ERROR_SYSTEM.getMsg();
    } else {
      this.code = resultCode.getCode();
      this.errorMsg = resultCode.getMsg();
    }
    if (!ResultCode.NORMAL.getCode().equals(code)) {
      isSuccess = false;
    }
    this.result = null;
  }

  public HttpResult(T result) {
    this.code = ResultCode.NORMAL.getCode();
    this.errorMsg = ResultCode.NORMAL.getMsg();
    this.result = result;
    if (!ResultCode.NORMAL.getCode().equals(code)) {
      isSuccess = false;
    }
  }

  public HttpResult(String code, T result, String errorMsg) {
    super();
    this.code = code;
    this.result = result;
    this.errorMsg = errorMsg;
    if (!ResultCode.NORMAL.getCode().equals(code)) {
      this.isSuccess = false;
    }
  }

  public HttpResult(T result, ResultCode resultCode) {
    super();
    this.code = resultCode.getCode();
    this.result = result;
    this.errorMsg = resultCode.getMsg();
    if (!ResultCode.NORMAL.getCode().equals(code)) {
      isSuccess = false;
    }
  }

  public static <T> HttpResult<T> failedResult(String code, String msg) {
    return new HttpResult<>(code, null, msg);
  }

  public static HttpResult create(ResultCode resultCode) {
    return new HttpResult(resultCode);
  }

  public static HttpResult create() {
    return new HttpResult();
  }


  @XmlElement
  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  @XmlElement
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @XmlElement
  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  @XmlElement
  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }


  public static <T> HttpResult<T> fromResult(Result<T> result) {
    if (result == null) {
      return createWithResultCode(ResultCode.ERROR_SYSTEM);
    }
    if (!result.isSuccess()) {
      return createWithError(result.getErrorCode(), result.getMessage());
    }
    return createWithData(result.getData());
  }

  public static <T, V> HttpResult<V> fromResult(Result<T> result, VoTransfer<T, V> voTransfer) {
    if (result == null) {
      return createWithResultCode(ResultCode.ERROR_SYSTEM);
    }
    if (!result.isSuccess()) {
      return createWithError(result.getErrorCode(), result.getMessage());
    }
    if (voTransfer == null) {
      return createWithResultCode(ResultCode.ERROR_SYSTEM);
    }
    return createWithData(voTransfer.transfer2VO(result.getData()));
  }

  public static <T> HttpResult<T> createWithErrorFromResult(Result<?> result) {
    if (result == null) {
      return createWithResultCode(ResultCode.ERROR_SYSTEM);
    }
    if (result.isSuccess()) {
      throw new IllegalArgumentException("result must be not successful.");
    }
    return createWithError(result.getErrorCode(), result.getMessage());
  }


  public static <T> HttpResult<T> createWithData(T data) {
    HttpResult<T> wrapper = new HttpResult<>();
    wrapper.setSuccess(true);
    wrapper.setResult(data);
    return wrapper;
  }

  public static HttpResult<Void> createWithVoid() {
    HttpResult<Void> wrapper = new HttpResult<>();
    wrapper.setSuccess(true);
    return wrapper;
  }

  public static <T> HttpResult<T> createWithResultCode(ResultCode resultCode) {
    HttpResult<T> wrapper = new HttpResult<>();
    if (resultCode != null) {
      if (resultCode.getIntCode().equals(ResultCode.NORMAL.getIntCode())) {
        wrapper.setSuccess(true);
      } else {
        wrapper.setSuccess(false);
      }
      wrapper.setCode(resultCode.getCode());
      wrapper.setErrorMsg(resultCode.getMsg());
    }
    return wrapper;
  }

  public static <T> HttpResult<T> createWithError(Integer errorCode, String errorMessage) {
    HttpResult<T> wrapper = new HttpResult<>();
    wrapper.setSuccess(false);
    wrapper.setCode(String.valueOf(errorCode));
    wrapper.setErrorMsg(errorMessage);
    return wrapper;
  }


}
