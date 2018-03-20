/**Created	by	chenshi  at	2018年3月20日 下午10:28:04*/
package com.girl.enums;

/**
 * @description:	ResultEnum.java
 * @packageName:	com.girl.enums
 * @projectName:	girl
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public enum ResultEnum {
	
	UNKNOW_ERROR((byte)-1,"未知错误"),
	SUCCESS((byte)200,"success");
	
	public Byte code;
	public String message;
	/**
	 * @param code
	 * @param message
	 */
	private ResultEnum(Byte code, String message) {
		this.code = code;
		this.message = message;
	}
	

}
