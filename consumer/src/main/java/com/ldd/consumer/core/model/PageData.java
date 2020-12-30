package com.ldd.consumer.core.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页数据
 *
 * @author Li Junqing
 **/
public final class PageData<T> implements Serializable {

  private static final long serialVersionUID = -4957881043002533671L;
  private List<T> data;
  private int totalNum;

  public static <T> PageData<T> empty() {
    return of(Collections.emptyList(), 0);
  }

  public static <T> PageData<T> of(List<T> data, int totalNum) {
    PageData<T> pageData = new PageData<>();
    pageData.setData(data);
    pageData.setTotalNum(totalNum);
    return pageData;
  }

  public PageData() {
  }

  public List<T> getData() {
    return this.data;
  }

  public int getTotalNum() {
    return this.totalNum;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public void setTotalNum(int totalNum) {
    this.totalNum = totalNum;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof PageData)) {
      return false;
    } else {
      PageData other = (PageData) o;
      List this$data = this.getData();
      List other$data = other.getData();
      if (this$data == null) {
        if (other$data == null) {
          return this.getTotalNum() == other.getTotalNum();
        }
      } else if (this$data.equals(other$data)) {
        return this.getTotalNum() == other.getTotalNum();
      }

      return false;
    }
  }

  @Override
  public int hashCode() {
    boolean PRIME = true;
    byte result = 1;
    List $data = this.getData();
    int result1 = result * 59 + ($data == null ? 43 : $data.hashCode());
    result1 = result1 * 59 + this.getTotalNum();
    return result1;
  }

  @Override
  public String toString() {
    return "PageData(data=" + this.getData() + ", totalNum=" + this.getTotalNum() + ")";
  }

}
