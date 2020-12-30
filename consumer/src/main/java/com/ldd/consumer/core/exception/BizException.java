package com.ldd.consumer.core.exception;

/**
 * 
 * Filename: BizException.java Description: 自定义业务异常 Copyright: Copyright (c)
 * 2015-2018 All Rights Reserved.
 * 
 * @author: smh
 *
 */
public class BizException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 8673080382721289259L;

	/**
	 * 创建一个<code>BizException</code>
	 * 
	 * @param message
	 *            自定义错误信息
	 */
	public BizException(String message) {
		super(message);
	}

}
