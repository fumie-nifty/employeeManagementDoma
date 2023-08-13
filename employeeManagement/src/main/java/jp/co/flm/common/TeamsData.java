package jp.co.flm.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsData {
	
	// メンションをしたい送信先のID（teamsアカウントアドレス）
	public void setUserId(String userId) {
		this.attachments[0].content.msteams.entities[0].mentioned.id = userId;
	}
	
	// メンションをしたい送信先の名前（teamsアカウント名）
	public void setUserName(String userName) {
		this.attachments[0].content.msteams.entities[0].mentioned.name = userName;
	}
	
	// 送信したいメッセージ
	public void setSendText (String sendText) {
		this.attachments[0].content.body[0].text = "<at>teams</at>さん " + sendText;
	}
	
	@JsonProperty("type")
	private String type = "message";

	@JsonProperty("attachments")
	private Attachments[] attachments = {new Attachments()};
	
	private class Attachments {
		@JsonProperty("contentType")
		private String contentType = "application/vnd.microsoft.card.adaptive";
		
		@JsonProperty("content")
		private Content content = new Content();
		
		private class Content {
			@JsonProperty("type")
			private String type = "AdaptiveCard";
			
			@JsonProperty("body")
			private Body[] body = {new Body()};
			
			private class Body {
				@JsonProperty("type")
				private String type = "TextBlock";
				
				@JsonProperty("text")
				private String text;

			}
			
			@JsonProperty("$schema")
			private String schema =
				"http://adaptivecards.io/schemas/adaptive-card.json";
			
			@JsonProperty("version")
			private String version = "1.0";
			
			@JsonProperty("msteams")
			private Msteams msteams = new Msteams();
			
			private class Msteams {
				@JsonProperty("entities")
				private Entities[] entities = {new Entities()};
				
				private class Entities {
					@JsonProperty("type")
					private String type = "mention";
					
					@JsonProperty("text")
					private String text = "<at>teams</at>";
					
					@JsonProperty("mentioned")
					private Mentioned mentioned = new Mentioned();
					
					private class Mentioned {
						@JsonProperty("id")
						private String id;
						
						@JsonProperty("name")
						private String name;

					}

				}

			}

		}

	}

}