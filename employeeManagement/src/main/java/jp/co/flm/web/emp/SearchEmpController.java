/**
 * SearchEmpController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.emp;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.form.EmployeeIdForm;
import jp.co.flm.service.SearchEmpService;
import jp.co.flm.service.dto.EmployeeAdaptiveCard;
import jp.co.flm.web.WebHookClient;

/**
 * SearchEmpControllerクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Controller
public class SearchEmpController {

	/** Service */
	@Autowired
	private SearchEmpService service;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebHookClient webHookClient;

//	@ModelAttribute(name = "LOGINUSER")
//	public String setLoginUser(@AuthenticationPrincipal LoginUser loginUser) {
//		String result = null;
//		if (loginUser != null) {
//			result = loginUser.getUsername();
//		}
//		return result;
//	}

	@RequestMapping("/search")
	public String search(Model model) {

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		return "/retrieve-input";
	}

	@RequestMapping(value = "/retrieveEmployee", params = "employeeId")
	public String retrieveReqParam(@Validated EmployeeIdForm form,
			BindingResult result,
			Model model) {

		// リクエストパラメーターの入力チェック
		if (result.hasErrors()) {
			return "/retrieve-input";
		}

		Integer employeeId = form.getEmployeeId();

		//Employeeオブジェクトの検索
		Employee employee = service.getEmployee(employeeId);

		// Modelに情報を設定
		model.addAttribute("employee", employee);
		

		String userId = "xkuga.fumie@contract.isid.co.jp";
		String userName = "久賀";
		String title = "クラス化テスト";
		String message ="あああああああああああああああああ";
		String href = "http://localhost:8080/";
		webHookClient.sendTeams(userId, userName, title, message, href);


		return "/retrieve-employee";
	}

	@RequestMapping("/retrieveAllEmployee")
	public String retrieveAllEmployee(Model model) {

		try {
			// Serviceの呼び出し
			List<Employee> employeeList = service.getAllEmployee();

			// Modelに情報を設定
			model.addAttribute("employeeList", employeeList);

		} catch (BusinessException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "/retrieve-list";
	}
	
	/**
	 * Teams送信べた書き
	 * @param title
	 * @param message
	 * @return
	 */
	public boolean sendTeamsKuga(String titel,String message) {
		boolean result = false;
		String url = "https://esq365.webhook.office.com/webhookb2/f23d105d-72e9-4b35-8c8d-707d946a1de4@fccbe2bf-88de-49c4-af92-1e9500cb29a4/IncomingWebhook/a4e12f85f334436eac1b46217a8545d8/2a42f0dd-1fb2-41a3-91e0-4afb29a27b7a";

		try {
			String userId = "xkuga.fumie@contract.isid.co.jp";
			String userName = "久賀";
			String title = "タイトル名";
			String mesg ="メッセージ文";
			String href = "http://localhost:8080/";

			// 送信データを JSONテキスト化
			EmployeeAdaptiveCard adaptiveCard = new EmployeeAdaptiveCard(userId,userName,title ,mesg,href);
			
			final ObjectMapper mapper = new ObjectMapper();
			String adaptiveJson = mapper.writeValueAsString(adaptiveCard);
			
			//リクエスト情報作成
			RequestEntity<?> req = RequestEntity 
					.post(URI.create(url)) 
					.contentType(MediaType.APPLICATION_JSON) 
					.body(adaptiveJson);

			// API 呼び出し
			restTemplate.exchange(req, String.class);

			result = true;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new RuntimeException();
		}

		return result;
	}

	/**
	 * 業務例外のハンドリング
	 * ハンドリングする例外クラス： BusinessException.class
	 */
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {

		// エラーメッセージをModelに設定
		model.addAttribute("message", e.getMessage());

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		return "/retrieve-input";
	}

}
