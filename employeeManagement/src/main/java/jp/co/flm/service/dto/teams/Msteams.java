package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class Msteams {
	
	public Msteams(String userId,String userName) {
		Entities[] entities = {new Entities(userId,userName)};
		this.entities = entities;
	}
	
	@JsonProperty("entities")
	private Entities[] entities ;

}
