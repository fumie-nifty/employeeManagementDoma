/**
 * Employee.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.form;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員番号を格納するFormクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdForm implements Serializable {

	@Min(100000)
	@Max(999999)
	@NotNull
	private Integer employeeId;

}

