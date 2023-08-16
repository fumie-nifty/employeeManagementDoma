/**
 * WebSecurityConfig.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.conf;

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
		
		//URLごとの認可の設定
		http.authorizeHttpRequests()										//URL毎の認可設定の開始
			.antMatchers("/images/**","/css/**","/script/*").permitAll()	//image、css、JavaScriptは未ログイン時でもアクセス可能
			.antMatchers("/").permitAll()									//トップ画面は未ログイン時でもアクセス可能
			.anyRequest().authenticated();									//その他のURLはログイン後のみアクセス可能

		//フォーム認証の設定
		http.formLogin()
			.loginPage("/login")					//ログイン画面URL
			//.loginProcessingUrl("/login")			//ユーザ名、パスワードの送信先URL
			.defaultSuccessUrl("/")					//ログイン成功後のリクエストURLがなかった場合の遷移先URL。
													//リクエストURLがある場合は認証後にリクエストURLに遷移する
													//ログイン後に必ず「/」に遷移させる場合は.defaultSuccessUrl("/",true)とする
			//.failureUrl("")						//ログイン失敗時の遷移先URL
			//.usernameParameter("")				//ログインフォームのユーザー名（デフォルト：username）
			//.passwordParameter("")				//ログインフォームのパスワード（デフォルト：password）
			.permitAll();							//ログイン画面は未ログイン時でもアクセス可能
		
		//ログアウトの設定
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))		//GETの場合
			//.logoutUrl("/logout")												//POSTの場合
			.permitAll();
		
		return http.build();
	}
	
	
	/**
	 * ログイン処理の設定
	 * @author kuga
	 * @version 1.0 2023/08/12
	 */
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
		
		@Autowired
		private MemberinfoService memberinfoService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(memberinfoService)				//ユーザー認証するサービスの設定
				.passwordEncoder(new Argon2PasswordEncoder());		//ハッシュ関数の登録
		}
	}
	
	
}
