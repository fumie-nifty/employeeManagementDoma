/**
 * FormMultipleSubmitController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.flm.form.TestForm;

/**
 * FormMultipleSubmitControllerクラス
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Controller
public class FormMultipleSubmitController {
	
	@RequestMapping("/multipleInput")
	public String multipleInput(Model model) {
		model.addAttribute("testForm", new TestForm());
		return "formtest";
	}

	@RequestMapping("/input01")
	public String input01(@ModelAttribute("testForm") TestForm form, Model model) {
		return "formtest";
	}

	@RequestMapping("/input02")
	public String input02(@ModelAttribute("testForm") TestForm form, Model model) {
		return "formtest";
	}

}
