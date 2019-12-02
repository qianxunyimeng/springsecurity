/**
 * 
 */
package com.qianxun.validate.code;

import com.qianxun.properties.SecurityProperties;
import com.qianxun.validate.code.image.ImageCodeGenerator;
import com.qianxun.validate.code.sms.DefaultSmsCodeSender;
import com.qianxun.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhailiang
 *
 */
@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}

	/**
	 * 如果 spring容器没有找到  SmsCodeSender  的实现，就会使用默认的发送短信的实现类，
	 * 所以用户可以  实现SmsCodeSender，自定义发送短信的方法
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}