/**
 * WebHookClient.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import jp.co.flm.service.TeamsMessageService;

/**
 * WebHookClientクラス
 * WebHook（REST API）を呼出すREST APIクライアントクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
public class WebHookClient {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TeamsMessageService teamsMessageService;

	public boolean sendTeams(String userId, String userName, String title, String message, String href) {
		boolean result = false;
		String url = "https://esq365.webhook.office.com/webhookb2/f23d105d-72e9-4b35-8c8d-707d946a1de4@fccbe2bf-88de-49c4-af92-1e9500cb29a4/IncomingWebhook/a4e12f85f334436eac1b46217a8545d8/2a42f0dd-1fb2-41a3-91e0-4afb29a27b7a";
		try {
			
			String adaptiveJson = teamsMessageService.createAdaptiveCardToJson(userId, userName, title, message, href);

			//リクエスト情報作成
			RequestEntity<?> req = RequestEntity
					.post(URI.create(url))
					.contentType(MediaType.APPLICATION_JSON)
					.body(adaptiveJson);

			// API 呼び出し
			restTemplate.exchange(req, String.class);

			result = true;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new RuntimeException();
		}

		return result;
	}
}
