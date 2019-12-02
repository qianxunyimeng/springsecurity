/**
 * 
 */
package com.qianxun.brower;


import com.qianxun.authentication.AbstractChannelSecurityConfig;
import com.qianxun.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.qianxun.properties.SecurityProperties;
import com.qianxun.validate.code.ValidateCodeFilter;
import com.qianxun.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
	@Autowired
	private SecurityProperties securityProperties;


	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		applyPasswordAuthenticationConfig(http);

		http.apply(validateCodeSecurityConfig)
				.and()
				.apply(smsCodeAuthenticationSecurityConfig)
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
			//http.httpBasic()
				.and()
				.authorizeRequests()   //对请求授权
				.antMatchers("/authentication/require","/code/*",securityProperties.getBrowser().getLoginPage()).permitAll()  //登录页面 不需要身份认证
		        .anyRequest()          //任何请求
				.authenticated()      //都需要身份认证
		        .and()
				.csrf()
				.disable();   // csrf跨站防护关闭
	}
}
