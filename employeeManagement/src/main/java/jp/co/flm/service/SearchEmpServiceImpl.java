/**
 * SearchEmpServiceImpl.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.dao.EmployeeDao;
import jp.co.flm.entity.Employee;

/**
 * SearchEmpServiceImplクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Service
public class SearchEmpServiceImpl implements SearchEmpService {

	/** Mapper */
	@Autowired
	private EmployeeDao dao;

	/**
	 * @see jp.co.flm.service.SearchEmpService#getEmployee(java.lang.Integer)
	 */
	@Override
	public Employee getEmployee(Integer employeeId) {
		//戻り値を用の変数の初期化
		Employee employee =null;

		// Mapperの呼び出し
		employee = dao.selectById(employeeId);

		// 検索結果が存在しない場合
		if (employee == null) {
			// 業務エラーを明示的に発生させる（エラーメッセージ[BIZERR301]）
			throw new BusinessException("該当する従業員情報がありません。");
		}

		//employeeを返却
		return employee;
	}

	/**
	 * @see jp.co.flm.service.SearchEmpService#getAllEmployee()
	 */
	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> employeeList = dao.selectAll();

		if(employeeList.isEmpty()) {
			throw new BusinessException("該当する従業員情報がありません。");
		}

		return employeeList;

	}

}
