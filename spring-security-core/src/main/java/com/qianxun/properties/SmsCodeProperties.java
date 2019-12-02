/**
 * 
 */
package com.qianxun.properties;

/**
 *
 * 短信验证码配置
 * @author zhailiang
 *
 */
public class SmsCodeProperties {

	/**
	 * 默认长度 6
	 */
	private int length = 6;

	/**
	 * 过期时间 单位秒 s
	 */
	private int expireIn = 60;

	/**
	 * 需要 拦截的 url,多个使用 "," 分割开来，例如 /user,/user/*
	 */
	private String url;

	public int getLength() {
		return length;
	}
	public void setLength(int lenght) {
		this.length = lenght;
	}
	public int getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
