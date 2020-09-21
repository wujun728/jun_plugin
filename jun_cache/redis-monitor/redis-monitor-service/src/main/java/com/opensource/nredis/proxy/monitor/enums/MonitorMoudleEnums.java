/**
 * 
 */
package com.opensource.nredis.proxy.monitor.enums;

/**
 * @author liubing
 * 监控模块
 */
public enum MonitorMoudleEnums {
	
	JMX(1,"JMX"),OLDSPACE(2,"老年代"),PERMSPACE(3,"持久代"),CPU(4,"CPU"),TOMCAT(5,"TOMCAT"),QUARTZ(6,"QUARTZ"),THREAD(7,"THREAD");
	private Integer code;
	
	private String message;

	/**
	 * @param code
	 * @param message
	 */
	private MonitorMoudleEnums(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static String getMessage(int code) {
		for (MonitorMoudleEnums c : MonitorMoudleEnums.values()) {
			if (c.getCode()== code) {
				return c.message;
			}
		}
		return null;
	}
}
