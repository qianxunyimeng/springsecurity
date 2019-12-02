/**
 * 
 */
package com.qianxun.validate.code.sms;

/**
 * @author zhailiang
 *
 */
public interface SmsCodeSender {

	/**
	 * 发送短信
	 * @param mobile  手机号
	 * @param code    验证码
	 */
	void send(String mobile, String code);

}
