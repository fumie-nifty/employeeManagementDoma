/**
 * TeamsMessageController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.flm.form.TeamsMessageForm;
import jp.co.flm.service.TeamsMessageService;
import jp.co.flm.web.WebHookClient;

/**
 * TeamsMessageControllerクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Controller
public class TeamsMessageController {
	
	@Autowired
	TeamsMessageService teamsMessageService;
	
	@Autowired
	WebHookClient webHookClient;

	@RequestMapping("/messageInput")
	public String search(Model model) {

		// フォームオブジェクトをModelに設定
		model.addAttribute("teamsMessageForm", new TeamsMessageForm());

		return "/message-input";
	}

	@RequestMapping(value = "/sendMessage")
	public String retrieveReqParam(@Validated TeamsMessageForm form,
			BindingResult result,
			Model model) {
		
		String userId = form.getUserId();
		String userName = form.getUserName();
		String title = form.getTitle();
		String message =form.getMessage();
		String href = form.getHref();
		
		webHookClient.sendTeams(userId, userName, title, message, href);
		
		model.addAttribute("teamsMessageForm", form);
		
		return "/message-result";
	}

}
