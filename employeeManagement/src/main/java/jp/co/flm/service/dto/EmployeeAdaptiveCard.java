package jp.co.flm.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.flm.service.dto.teams.Body;
import jp.co.flm.service.dto.teams.Msteams;

public class EmployeeAdaptiveCard {

	public EmployeeAdaptiveCard(String userId,
								String userName,
								String title,
								String message) {
		
		this.attachments[0].content.msteams= new Msteams(userId, userName);
		Body[] body =  new Body[3];
		body[0]= new Body("TextBlock",title);
		body[1]= new Body("TextBlock","<at>teams</at>さん");
		body[2]= new Body("TextBlock",message);
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
