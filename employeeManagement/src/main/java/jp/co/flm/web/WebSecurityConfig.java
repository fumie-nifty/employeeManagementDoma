/**
 * WebSecurityConfig.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.flm.service.MemberinfoService;

/**
 * SpringSecurityコンフィグレーションクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
			.antMatchers("/images/**","/css/**","/script/*").permitAll()
			.anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/").permitAll();	//ログイン後に必ず「/」に遷移させる場合は.defaultSuccessUrl("/",true)とする
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).permitAll();
		
		return http.build();
	}
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
		
		@Autowired
		private MemberinfoService memberinfoService;
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(memberinfoService).passwordEncoder(new Argon2PasswordEncoder());
		}
	}
}
