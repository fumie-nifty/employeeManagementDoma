/**
 * Mentioned.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Teamsユーザークラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
@Data
@AllArgsConstructor
public class Mentioned {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

}
