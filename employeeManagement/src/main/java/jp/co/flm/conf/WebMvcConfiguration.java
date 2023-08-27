/**
 * WebMvcConfiguration.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.co.flm.common.logger.AppLogger;


/**
 * WebMvcConfigurationクラス
 * @author kuga
 * @version 1.0 2023/08/27
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

        @Bean
        AppLogger appLogger() {
            return new AppLogger();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(appLogger())
                 .addPathPatterns("/**");

    }

}
