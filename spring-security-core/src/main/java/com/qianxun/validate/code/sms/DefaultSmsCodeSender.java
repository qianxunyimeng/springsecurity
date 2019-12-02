/**
 * 
 */
package com.qianxun.validate.code.sms;

/**
 * @author zhailiang
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	/**
	 * 默认发送短信方法
	 * @param mobile  手机号
	 * @param code    验证码
	 */
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
