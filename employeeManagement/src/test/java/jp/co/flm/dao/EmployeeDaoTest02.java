package jp.co.flm.dao;

//import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.seasar.doma.jdbc.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.flm.entity.Employee;

/**
 * @author FLM
 * @version 1.0 yyyy/mm/dd
 */
@SpringBootTest
@DisplayName("PT001_01:EmployeeDaoのテスト")
public class EmployeeDaoTest02 {

	@Autowired
	EmployeeDao sut;

	@Test
	@DisplayName("PT001_01_001：メンバーが検索できる場合")
	void testSelectById_test1() {
		// setup
		Integer testArg_employeeId = 922101;
		Employee expected = new Employee();
		expected.setEmployeeId(922101);
		expected.setEmployeeName("鈴木　一郎");
		expected.setSection("研修部");
		expected.setPhone("7700-2257");

		// assert
		Employee actual = sut.selectById(testArg_employeeId);
		assertThat(actual,is(expected));

	}

	@Test
	@DisplayName("PT001_01_002：メンバーが検索できない場合")
	void testSelectById_test2() {
		// setup
		Integer testArg_employeeId = 922109;

		// assert
		//Employee actual = sut.selectById(testArg_employeeId);
		//assertThat(actual,nullValue());
		assertThrows(NoResultException.class, () -> sut.selectById(testArg_employeeId));

	}

}