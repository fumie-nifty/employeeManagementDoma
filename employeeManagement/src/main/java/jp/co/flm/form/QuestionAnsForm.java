/**
 * QuestionAnsForm.java
 * All Rights Reserved. Copyright(c) Fujitsu Learning Media Limited
 */ 
package jp.co.flm.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuestionAnsForm
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnsForm implements Serializable {

	private int question_id;
	private String answer_text;
	private Integer[] answer_choice_id_List;

}
