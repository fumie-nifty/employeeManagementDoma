/**
 * EmployeeDao.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import jp.co.flm.conf.ConfigAutowireable;
import jp.co.flm.entity.Employee;

/**
 * Employeeテーブルに対応するDaoインターフェース
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Dao
@ConfigAutowireable
public interface EmployeeDao {
	
	@Select
	List<Employee> selectAll();
	
	@Select
	Employee selectById(Integer employeeId);
	
	
}