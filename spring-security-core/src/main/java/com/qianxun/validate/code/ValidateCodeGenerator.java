/**
 * 
 */
package com.qianxun.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhailiang
 *
 */
public interface ValidateCodeGenerator {

    //生成验证码  图片验证码或者 短信验证码
	ValidateCode generate(ServletWebRequest request);
	
}
