/**
 * QuestionAnswerForm.java
 * All Rights Reserved. Copyright(c) Fujitsu Learning Media Limited
 */ 
package jp.co.flm.form;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QuestionAnswerForm
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerForm implements Serializable {

	private List<QuestionAnsForm> qeuestionAnsFormList;
}
