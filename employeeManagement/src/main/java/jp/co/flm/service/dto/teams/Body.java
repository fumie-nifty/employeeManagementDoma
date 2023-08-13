package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Body {
		@JsonProperty("type")
		private String type = "TextBlock";

		@JsonProperty("text")
		private String text;

		@JsonProperty("size")
		private String size;

		@JsonProperty("weight")
		private String weight;
		
		public Body(String type,String text) {
			this.type= type;
			this.text =text;
		}

}
