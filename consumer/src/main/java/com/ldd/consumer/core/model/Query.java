package com.ldd.consumer.core.model;

import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Li Junqing
 **/
@NoArgsConstructor
public class Query<T> implements Serializable {

  private static final long serialVersionUID = 2800291946468264236L;
  private T data;
  private int pageNum = 1;
  private int pageSize = 10;

  public Query(T data) {
    this.data = data;
  }

  public int getStart() {
    return (this.pageNum - 1) * this.pageSize;
  }

  public T getData() {
    return this.data;
  }

  public int getPageNum() {
    return this.pageNum;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof Query)) {
      return false;
    } else {
      Query other = (Query) o;
      if (!other.canEqual(this)) {
        return false;
      } else {
        Object this$data = this.getData();
        Object other$data = other.getData();
        if (this$data == null) {
          if (other$data == null) {
            return this.getPageNum() == other.getPageNum() && this.getPageSize() == other
                .getPageSize();
          }
        } else if (this$data.equals(other$data)) {
          return this.getPageNum() == other.getPageNum() && this.getPageSize() == other
              .getPageSize();
        }

        return false;
      }
    }
  }

  protected boolean canEqual(Object other) {
    return other instanceof Query;
  }

  @Override
  public int hashCode() {
    boolean PRIME = true;
    byte result = 1;
    Object $data = this.getData();
    int result1 = result * 59 + ($data == null ? 43 : $data.hashCode());
    result1 = result1 * 59 + this.getPageNum();
    result1 = result1 * 59 + this.getPageSize();
    return result1;
  }

  @Override
  public String toString() {
    return "Query(data=" + this.getData() + ", pageNum=" + this.getPageNum() + ", pageSize=" + this
        .getPageSize() + ")";
  }

}
