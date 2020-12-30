package com.ldd.consumer.core.exception;

/**
 * create by jiangcong@helianhealth.com 2019/09/25 16:13
 **/
public class HdtsReserveException extends RuntimeException {

  public HdtsReserveException() {
    super();
  }

  public HdtsReserveException(String message) {
    super(message);
  }

  public HdtsReserveException(String message, Throwable cause) {
    super(message, cause);
  }

  public HdtsReserveException(Throwable cause) {
    super(cause);
  }
}
