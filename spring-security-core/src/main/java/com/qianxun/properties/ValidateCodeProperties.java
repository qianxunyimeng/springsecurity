/**
 * 
 */
package com.qianxun.properties;

/**
 *
 * 验证码配置，包括图片验证码和短信验证码
 * @author zhailiang
 *
 */
public class ValidateCodeProperties {
	
	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();

	public ImageCodeProperties getImage() {
		return image; 
	}

	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}

	public SmsCodeProperties getSms() {
		return sms;
	}

	public void setSms(SmsCodeProperties sms) {
		this.sms = sms;
	}
	
}
