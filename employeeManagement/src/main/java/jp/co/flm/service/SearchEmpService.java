/**
 * SearchEmpService.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service;

import java.util.List;

import jp.co.flm.entity.Employee;

/**
 * SearchEmpServiceクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
public interface SearchEmpService {

	public Employee getEmployee(Integer employeeId);

	public List<Employee> getAllEmployee();

}
