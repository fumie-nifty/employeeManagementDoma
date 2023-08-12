/**
 * TopController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TopControllerクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Controller
public class TopController {
	
	
	/**
	 * 画面で表示するログインユーザー名（LOGINUSER）をModelに格納する
	 * @param loginUser 認証済みユーザー情報
	 * @return
	 */
//	@ModelAttribute(name = "LOGINUSER")
//	public String setLoginUser(@AuthenticationPrincipal LoginUser loginUser) {
//		String result = null;
//		if(loginUser!=null) {
//			result=loginUser.getUsername();
//		}
//		return result;
//	}
	
	
	/**
	 * ログイン画面表示
	 * url：/login
	 * 遷移先HTML:
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	
	@RequestMapping("/")
	public String handler() {
		
		return "/top";
	}

}
