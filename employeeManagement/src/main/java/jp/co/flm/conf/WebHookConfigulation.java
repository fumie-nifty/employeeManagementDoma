/**
 * WebHookConfigulation.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.conf;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import jp.co.flm.web.WebHookClient;

/**
 * WebHookConfigulationコンフィグレーションクラス
 * 以下のクラスをDIコンテナに登録
 *   ・RestTemplate
 *   ・WebHookClient
 * @author kuga
 * @version 1.0 2023/08/15
 */
@Configuration
public class WebHookConfigulation {
	
	@Value("${http.proxy.host}")
	private String PROXY_HOST;
	
	@Value("${http.proxy.port}")
	private int PROXY_PORT;
	
	private String END_POINT ="https://esq365.webhook.office.com";

	/**
	 * REST API(Web API)を呼び出すためのクラスをDIコンテナに登録
	 * @param builder RestTemplate作成に使用するビルダー
	 * @return 
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		//Proxyオブジェクトの生成
		Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));
        
		//RequestFactoryにProxy設定
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setProxy(proxy);
		
		//REST API(Web API)を呼び出すためのクラスの生成
		RestTemplate restTemplate=builder
				.requestFactory(()->requestFactory)
				.setConnectTimeout(Duration.ofSeconds(5l))
				.setReadTimeout(Duration.ofSeconds(5l))
				.build();
		//restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
	
	@Bean
	public WebHookClient webHookClient() {
		return new WebHookClient();
	}
}
