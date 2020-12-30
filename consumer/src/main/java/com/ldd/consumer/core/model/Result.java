package com.ldd.consumer.core.model;
/**
 * Created by lee on 18/1/6.
 */

import com.ldd.consumer.core.exception.ResultCode;

import java.io.Serializable;

/**
 * 结果类
 *
 * @author Li Junqing
 **/
public class Result<T> implements Serializable {

  private static final long serialVersionUID = 8275170170237759378L;
  private boolean success;
  private T data;
  private int errorCode;
  private String message;

  public static <T> Result<T> createWithData(T data) {
    Result result = new Result();
    result.setData(data);
    result.setSuccess(true);
    return result;
  }

  public static Result<Void> createWithVoid() {
    Result result = new Result();
    result.setSuccess(true);
    return result;
  }

  public static <T> Result<T> createWithError(int errorCode, String message) {
    Result result = new Result();
    result.setSuccess(false);
    result.setErrorCode(errorCode);
    result.setMessage(message);
    return result;
  }

  public static <T> Result<T> createWithResultCode(ResultCode errorCode) {
    if (ResultCode.NORMAL.equals(errorCode)) {
      return createWithData(null);
    } else {
      return createWithError(errorCode.getIntCode(), errorCode.getMsg());
    }
  }

  public Result() {
  }

  public boolean isSuccess() {
    return this.success;
  }

  public T getData() {
    return this.data;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public String getMessage() {
    return this.message;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof Result)) {
      return false;
    } else {
      Result other = (Result) o;
      if (!other.canEqual(this)) {
        return false;
      } else if (this.isSuccess() != other.isSuccess()) {
        return false;
      } else {
        label41:
        {
          Object this$data = this.getData();
          Object other$data = other.getData();
          if (this$data == null) {
            if (other$data == null) {
              break label41;
            }
          } else if (this$data.equals(other$data)) {
            break label41;
          }

          return false;
        }

        if (this.getErrorCode() != other.getErrorCode()) {
          return false;
        } else {
          String this$message = this.getMessage();
          String other$message = other.getMessage();
          if (this$message == null) {
            if (other$message != null) {
              return false;
            }
          } else if (!this$message.equals(other$message)) {
            return false;
          }

          return true;
        }
      }
    }
  }

  protected boolean canEqual(Object other) {
    return other instanceof Result;
  }

  @Override
  public int hashCode() {
    boolean PRIME = true;
    byte result = 1;
    int result1 = result * 59 + (this.isSuccess() ? 79 : 97);
    Object $data = this.getData();
    result1 = result1 * 59 + ($data == null ? 43 : $data.hashCode());
    result1 = result1 * 59 + this.getErrorCode();
    String $message = this.getMessage();
    result1 = result1 * 59 + ($message == null ? 43 : $message.hashCode());
    return result1;
  }

  @Override
  public String toString() {
    return "Result(success=" + this.isSuccess() + ", data=" + this.getData() + ", errorCode=" + this
        .getErrorCode() + ", message=" + this.getMessage() + ")";
  }
}

