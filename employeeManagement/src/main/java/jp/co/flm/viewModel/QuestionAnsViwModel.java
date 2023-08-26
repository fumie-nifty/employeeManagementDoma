/**
 * QuestionAnsViwmodel.java
 * All Rights Reserved. Copyright(c) Fujitsu Learning Media Limited
 */ 
package jp.co.flm.viewModel;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuestionAnsViwmodel
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnsViwModel implements Serializable {

	private int question_id;
	private int question_number;
	private int question_type_id;
	private int require_flag;
	private String question_text;
	private Map<Integer,String> choiceMap;

}
