package com.ldd.consumer.core.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataResult<T> implements Serializable {

  /**
   * 数据部门推荐项目
   */
  private static final long serialVersionUID = -873736659882836986L;

  private Integer code;
  private T data;
  private String message;
  private Boolean success;


}
