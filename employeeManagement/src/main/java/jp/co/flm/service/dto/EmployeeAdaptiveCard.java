/**
 * EmployeeAdaptiveCard.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.flm.service.dto.teams.Body;
import jp.co.flm.service.dto.teams.Msteams;

/**
 * アダプティブカード作成クラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
public class EmployeeAdaptiveCard {

	/**
	 * @param userId	TeamsユーザーID
	 * @param userName	ユーザー名
	 * @param title		メッセージタイトル
	 * @param message	メッセージ本文
	 * @param href		アンケートURL
	 */
	public EmployeeAdaptiveCard(String userId,
								String userName,
								String title,
								String message,
								String href) {
		//メンションユーザーの登録
		this.attachments[0].content.msteams= new Msteams(userId, userName);
		//本文作成
		Body[] body =  {
				new Body("TextBlock",title,"Medium","Bolder"),	//タイトル
				new Body("TextBlock","<at>teams</at>さん"),		//メンション
				new Body("TextBlock",message),					//メッセージ本文
				new Body("TextBlock","[アンケート参照](" + href + ")")	//ハイパーリンク
				};
		//カードに本文登録
		this.attachments[0].content.body =body;
		

	}

	@JsonProperty("type")
	private String type = "message";

	@JsonProperty("attachments")
	private Attachments[] attachments = { new Attachments() };

	private class Attachments {
		@JsonProperty("contentType")
		private String contentType = "application/vnd.microsoft.card.adaptive";

		@JsonProperty("content")
		private Content content = new Content();

		private class Content {
			@JsonProperty("type")
			private String type = "AdaptiveCard";

			@JsonProperty("body")
			private Body[] body;

			@JsonProperty("$schema")
			private String schema = "http://adaptivecards.io/schemas/adaptive-card.json";

			@JsonProperty("version")
			private String version = "1.0";

			@JsonProperty("msteams")
			private Msteams msteams;

		}

	}
}
