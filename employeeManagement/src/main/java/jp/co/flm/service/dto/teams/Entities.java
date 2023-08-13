/**
 * Entities.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * メンションエントリークラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
@Data
public class Entities {
	
	@JsonProperty("type")
	private String type = "mention";

	@JsonProperty("text")
	private String text = "<at>teams</at>";

	@JsonProperty("mentioned")
	private Mentioned mentioned;
	
	public Entities(String userId,String userName) {
		this.mentioned= new Mentioned(userId,userName);
	}

}
