/**
 * TestForm.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestFormクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestForm implements Serializable {

	private String input01;
	private Integer[] input02;

}

