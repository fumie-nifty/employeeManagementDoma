package jp.co.flm.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.flm.service.dto.EmployeeAdaptiveCard;

@Service
public class TeamsMessageServiceImpl implements TeamsMessageService {

	@Override
	public String createAdaptiveCardToJson(String userId, String userName, String title, String message, String href) {
		String adaptiveJson = null;
		try {
			// 送信データを JSONテキスト化
			EmployeeAdaptiveCard adaptiveCard = new EmployeeAdaptiveCard(userId, userName, title, message, href);

			final ObjectMapper mapper = new ObjectMapper();
			adaptiveJson = mapper.writeValueAsString(adaptiveCard);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return adaptiveJson;
	}

}
