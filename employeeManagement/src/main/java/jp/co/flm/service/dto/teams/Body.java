/**
 * Body.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * アダプティブカードの本文クラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
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
