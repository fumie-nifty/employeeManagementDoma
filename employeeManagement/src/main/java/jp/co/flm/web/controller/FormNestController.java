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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.flm.form.QuestionAnsForm;
import jp.co.flm.form.QuestionAnswerForm;
import jp.co.flm.viewModel.EnqueteAnsViewModel;
import jp.co.flm.viewModel.QuestionAnsViwModel;

/**
 * FormMultipleSubmitControllerクラス
 * @author kuga
 * @version 1.0 2023/08/26
 */
@SessionAttributes(types = EnqueteAnsViewModel.class)
@Controller
public class FormNestController {

	@RequestMapping("/nestInput")
	public String nestInput(Model model) {

		//アンケート回答入力用
		QuestionAnswerForm questionAnswerForm = new QuestionAnswerForm();
		List<QuestionAnsForm> qeuestionAnsFormListInput = new ArrayList<QuestionAnsForm>();
		QuestionAnsForm questionAnsForm = null;
 
		//アンケート回答表示用
		EnqueteAnsViewModel enqueteAnsViewModel = new EnqueteAnsViewModel();
		List<QuestionAnsViwModel> questionAnsViwModelList = new ArrayList<QuestionAnsViwModel>();
		Map<Integer,String> choiceMap = null;
		QuestionAnsViwModel questionAnsViwModel = null;
		
		//アンケート回答表示用　データの設定
		enqueteAnsViewModel.setEnquete_id(10);
		enqueteAnsViewModel.setEnquete_name("入社後の様子");

		//単一テキスト入力
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(1);
		qeuestionAnsFormListInput.add(questionAnsForm);
		questionAnsViwModel = new QuestionAnsViwModel();
		questionAnsViwModel.setQuestion_id(1);
		questionAnsViwModel.setQuestion_number(1);
		questionAnsViwModel.setRequire_flag(1);
		questionAnsViwModel.setQuestion_text("質問ａ");
		questionAnsViwModel.setQuestion_type_id(1);
		questionAnsViwModelList.add(questionAnsViwModel);

		//単一選択
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(2);
		qeuestionAnsFormListInput.add(questionAnsForm);
		questionAnsViwModel = new QuestionAnsViwModel();
		questionAnsViwModel.setQuestion_id(2);
		questionAnsViwModel.setQuestion_number(2);
		questionAnsViwModel.setQuestion_type_id(2);
		questionAnsViwModel.setRequire_flag(1);
		questionAnsViwModel.setQuestion_text("質問ｂ");
		choiceMap = new HashMap<>();
		choiceMap.put(1, "選択１");
		choiceMap.put(2, "選択２");
		choiceMap.put(3, "選択３");
		questionAnsViwModel.setChoiceMap(choiceMap);
		questionAnsViwModelList.add(questionAnsViwModel);

		//複数選択
		questionAnsForm = new QuestionAnsForm();
		questionAnsForm.setQuestion_id(3);
		qeuestionAnsFormListInput.add(questionAnsForm);
		questionAnsViwModel = new QuestionAnsViwModel();
		questionAnsViwModel.setQuestion_id(3);
		questionAnsViwModel.setQuestion_number(3);
		questionAnsViwModel.setQuestion_type_id(3);
		questionAnsViwModel.setRequire_flag(1);
		questionAnsViwModel.setQuestion_text("質問ｃ");
		choiceMap = new HashMap<>();
		choiceMap.put(4, "選択Ａ");
		choiceMap.put(5, "選択Ｂ");
		choiceMap.put(6, "選択Ｃ");
		questionAnsViwModel.setChoiceMap(choiceMap);
		questionAnsViwModelList.add(questionAnsViwModel);

		enqueteAnsViewModel.setQuestionAnsViwModelList(questionAnsViwModelList);
		questionAnswerForm.setQeuestionAnsFormList(qeuestionAnsFormListInput);

		//アンケート回答表示用
		model.addAttribute("enqueteAnsViewModel", enqueteAnsViewModel);
		//アンケート回答入力用
		model.addAttribute("questionAnswerForm", questionAnswerForm);

		return "questionnaire-input";
	}

	@RequestMapping("/questionaryInput")
	public String questionaryInput(QuestionAnswerForm form, Model model,SessionStatus status) {
		
		QuestionAnswerForm questionAnswerForm = form;
		
		model.addAttribute("questionAnswerForm", questionAnswerForm);
		
		status.setComplete();
		
		return "questionnaire-result";

	}

}
