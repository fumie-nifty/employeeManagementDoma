/**
 * SystemExceptionHandler.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common.exception;

import org.seasar.doma.DomaException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * SystemExceptionHandlerクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@ControllerAdvice
public class SystemExceptionHandler {

	/**
	 * システム例外（SystemException・CommunicationsException）をハンドリングする
	 * DomaExceptionかJdbcException
	 */
	@ExceptionHandler({ SystemException.class ,DomaException.class})
	public String handleError(Model model) {
		model.addAttribute("message", "システムエラーです。システム管理者に連絡してください。");
		return "/error";
	}

}

