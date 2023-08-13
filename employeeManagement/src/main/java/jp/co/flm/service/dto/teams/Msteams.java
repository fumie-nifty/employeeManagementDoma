/**
 * Msteams.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * メンション用クラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
@Data
public class Msteams {
	
	public Msteams(String userId,String userName) {
		Entities[] entities = {new Entities(userId,userName)};
		this.entities = entities;
	}
	
	@JsonProperty("entities")
	private Entities[] entities ;

}
