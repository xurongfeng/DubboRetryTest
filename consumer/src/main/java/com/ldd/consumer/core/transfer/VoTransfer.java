package com.ldd.consumer.core.transfer;

public interface VoTransfer<T, V> {

  /**
   * T类型的对象 -> V类型的对象
   *
   * @param t 待转换的对象
   * @return 转换后的对象
   */
  V transfer2VO(T t);
}
