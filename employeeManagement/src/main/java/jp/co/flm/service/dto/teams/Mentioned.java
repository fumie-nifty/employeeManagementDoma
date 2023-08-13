package jp.co.flm.service.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mentioned {
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

}
