/**
 * 
 */
package com.qianxun.properties;

import sun.security.util.SecurityConstants;

/**
 * @author zhailiang
 *
 */
public class BrowserProperties {
	

	
	private String signUpUrl = "/qx-signUp.html";
	
	private String loginPage = "/qx-signIn.html";    //默认登录页

	private LoginResponseType loginType = LoginResponseType.JSON;   //登录返回方式

	private int rememberMeSeconds = 3600;  //记住我 有效时间，单位秒 s

	public String getSignUpUrl() {
		return signUpUrl;
	}



	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
}
