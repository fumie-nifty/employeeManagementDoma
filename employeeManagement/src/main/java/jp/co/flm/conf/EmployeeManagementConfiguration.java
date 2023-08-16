/**
 * EmployeeManagementConfiguration.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import jp.co.flm.common.aspect.LoggingAspect;

/**
 * EmployeeManagementコンフィグレーションクラス
 * @author FLM
 * @version 1.0.0
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class EmployeeManagementConfiguration {

	/**
	 * ResourceBundleMessageSourceのBean定義
	 * @return {@code ResourceBundleMessageSource}
	 */
	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource
			= new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("messages");
		return messageSource;
	}

	/**
	 * LoggingAspectクラスのBean定義
	 * @return {@code LoggingAspect}
	 */
	/*
	@Bean
	LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	*/
}
