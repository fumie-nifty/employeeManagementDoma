/**
 * TopController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TopControllerクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Controller
public class TopController {
	
	/**
	 * ログイン画面表示
	 * url：/login
	 * 遷移先HTML:login.html
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	
	/**
	 * トップ画面表示
	 * url：/
	 * 遷移先HTML:top.html
	 * @return
	 */
	@RequestMapping("/")
	public String handler() {
		
		return "/top";
	}

}
