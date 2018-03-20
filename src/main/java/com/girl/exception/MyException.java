/**Created	by	chenshi  at	2018年3月20日 下午11:00:04*/
package com.girl.exception;

/**
 * @description:	MyException.java
 * @packageName:	com.girl.exception
 * @projectName:	girl
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@SuppressWarnings("serial")
public class MyException extends RuntimeException{

	private Byte code;

	/**
	 * @param code
	 */
	public MyException(Byte code,String message) {
		super(message);
		this.code = code;
	}

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}
	
	
}
