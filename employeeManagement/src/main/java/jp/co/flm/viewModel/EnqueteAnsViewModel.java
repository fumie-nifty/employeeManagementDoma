/**
 * EnqueteAnsViewModel.java
 * All Rights Reserved. Copyright(c) Fujitsu Learning Media Limited
 */ 
package jp.co.flm.viewModel;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EnqueteAnsViewModel
 * @author kuga
 * @version 1.0 2023/08/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnqueteAnsViewModel implements Serializable {
	
	private int enquete_id;
	private String enquete_name;
	private List<QuestionAnsViwModel> questionAnsViwModelList;

}
