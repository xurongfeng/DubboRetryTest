package com.ldd.consumer.core.exception;


public class ResultBizException extends RuntimeException {

  private ResultCode code;

  public ResultBizException(ResultCode code) {
    super(code.getMsg());
    this.code = code;
  }


  public ResultCode getCode() {
    return code;
  }
}
