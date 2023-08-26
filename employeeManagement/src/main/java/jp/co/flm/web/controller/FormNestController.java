/**
 * FormNestController.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.flm.form.ChoiceForm;
import jp.co.flm.form.EnqueteForm;
import jp.co.flm.form.QuestionAnsForm;

/**
 * FormMultipleSubmitControllerクラス
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Controller
public class FormNestController {

	@RequestMapping("/nestInput")
	public String nestInput(Model model) {

		EnqueteForm enqueteForm = new EnqueteForm();
		enqueteForm.setEnquete_id(10);
		enqueteForm.setEnquete_name("入社後の様子");

		List<QuestionAnsForm> questionAnsFormList = new ArrayList<QuestionAnsForm>();
		QuestionAnsForm questionAnsForm = null;
		List<ChoiceForm> choiceFormList = null;
		//List<Integer> answer_choice_id_List = null;
		Map<Integer,String> choiceMap = null;

		//テキスト回答用
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(1);
		questionAnsForm.setQuestion_number(1);
		questionAnsForm.setQuestion_type_id(1);
		questionAnsForm.setRequire_flag(1);
		questionAnsForm.setQuestion_text("質問ａ");

		questionAnsFormList.add(questionAnsForm);

		//単一選択
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(2);
		questionAnsForm.setQuestion_number(2);
		questionAnsForm.setQuestion_type_id(2);
		questionAnsForm.setRequire_flag(1);
		questionAnsForm.setQuestion_text("質問ｂ");
		choiceMap = new HashMap<>();
		choiceMap.put(1, "選択１");
		choiceMap.put(2, "選択２");
		choiceMap.put(3, "選択３");
//		choiceFormList = new ArrayList<ChoiceForm>();
//		choiceFormList.add(new ChoiceForm(1, 2, 1, "選択１"));
//		choiceFormList.add(new ChoiceForm(2, 2, 2, "選択２"));
//		choiceFormList.add(new ChoiceForm(3, 2, 3, "選択３"));
//		questionAnsForm.setChoiceFormList(choiceFormList);
//		answer_choice_id_List = new ArrayList<AnswerChoiceIdListForm>();
//		questionAnsForm.setAnswer_choice_id_List(answer_choice_id_List);

		questionAnsFormList.add(questionAnsForm);

		//複数選択
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(3);
		questionAnsForm.setQuestion_number(3);
		questionAnsForm.setQuestion_type_id(3);
		questionAnsForm.setRequire_flag(1);
		questionAnsForm.setQuestion_text("質問ｃ");
		choiceMap = new HashMap<>();
		choiceMap.put(4,  "選択Ａ");
		choiceMap.put(5, "選択Ｂ");
		choiceMap.put(6, "選択Ｃ");
		
		
//		choiceFormList = new ArrayList<ChoiceForm>();
//		choiceFormList.add(new ChoiceForm(1, 2, 1, "選択Ａ"));
//		choiceFormList.add(new ChoiceForm(2, 2, 2, "選択Ｂ"));
//		choiceFormList.add(new ChoiceForm(3, 2, 3, "選択Ｃ"));
		questionAnsForm.setChoiceMap(choiceMap);
		//answer_choice_id_List = new ArrayList<Integer>();
		//questionAnsForm.setAnswer_choice_id_List(answer_choice_id_List);

		questionAnsFormList.add(questionAnsForm);

		enqueteForm.setQuestionAnsFormList(questionAnsFormList);

		model.addAttribute("enqueteForm", enqueteForm);

		return "questionnaire-input";
	}

	@RequestMapping("/questionaryInput")
	public String questionaryInput(EnqueteForm form, Model model) {
		
		EnqueteForm enqueteForm = form;
		
		return "";

	}

}
