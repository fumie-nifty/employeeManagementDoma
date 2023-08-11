/**
 * Employee.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.entity;

import java.io.Serializable;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import lombok.Data;

/**
 * Employeeテーブルに対応するEntityクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Data
@Entity
public class Employee implements Serializable{
	
	@Id
	private Integer employeeId;
	
	private String employeeName;
	
	private String section;
	
	private String phone;

	
}
