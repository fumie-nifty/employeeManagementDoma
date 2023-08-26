//package jp.co.flm.dao;
//
//import static com.github.springtestdbunit.annotation.DatabaseOperation.*;
//import static org.assertj.core.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.seasar.doma.jdbc.SqlExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//
//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
//import com.github.springtestdbunit.annotation.DatabaseTearDown;
//
//import jp.co.flm.entity.Employee;
//import jp.co.flm.test.util.ExecuteQueryForTestService;
//
///**
// * @author kuga
// * @version 1.0 2023/07/12
// * DbUnit、assertj
// */
//@SpringBootTest
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//		DirtiesContextTestExecutionListener.class,
//		TransactionalTestExecutionListener.class,
//		DbUnitTestExecutionListener.class })
//@DatabaseSetup("classpath:AllTest/setupDB.xml")
//@DatabaseTearDown("classpath:AllTest/setupDB.xml")
//@DisplayName("PT001_02:EmployeeDaoのテスト")
//public class EmployeeDaoTest {
//
//	@Autowired
//	EmployeeDao sut;
//
//	@Autowired
//	ExecuteQueryForTestService executeQueryForTestService;
//
//	@Test
//	@DisplayName("PT001_02_001：従業員が検索できる場合")
//	void testSelectById_test1() {
//		// setup
//		Integer testArg_employeeId = 922101;
//		Employee expected = new Employee();
//		expected.setEmployeeId(922101);
//		expected.setEmployeeName("鈴木　一郎");
//		expected.setSection("研修部");
//		expected.setPhone("7700-2257");
//
//		// assert
//		assertThat(sut.selectById(testArg_employeeId)).isEqualTo(expected);
//
//	}
//
//	@Test
//	@DisplayName("PT001_02_002：従業員が検索できる場合（存在しない従業員番号）")
//	void testSelectById_test2() {
//		// setup
//		Integer testArg_employeeId = 922100;
//
//		// assert
//		assertThat(sut.selectById(testArg_employeeId)).isNull();
//	}
//
//	@Test
//	@DatabaseSetup(type = DELETE_ALL)
//	@DisplayName("PT001_02_003：従業員が検索できる場合（レコード０件）")
//	void testSelectById_test3() {
//		// setup
//		Integer testArg_employeeId = 922101;
//
//		// assert
//		assertThat(sut.selectById(testArg_employeeId)).isNull();
//	}
//
//	@Test
//	@DisplayName("PT001_02_004:従業員情報のリストが取得できる場合")
//	void testSelectAll_test1() {
//		// setup
//		List<Employee> expected = new ArrayList<>();
//
//		Employee emp = new Employee();
//		emp.setEmployeeId(922101);
//		emp.setEmployeeName("鈴木　一郎");
//		emp.setSection("研修部");
//		emp.setPhone("7700-2257");
//		expected.add(emp);
//
//		emp = new Employee();
//		emp.setEmployeeId(922102);
//		emp.setEmployeeName("田村　正人");
//		emp.setSection("研修部");
//		emp.setPhone("7700-2258");
//		expected.add(emp);
//
//		emp = new Employee();
//		emp.setEmployeeId(922103);
//		emp.setEmployeeName("松田　明美");
//		emp.setSection("開発部");
//		emp.setPhone("7712-4418");
//		expected.add(emp);
//
//		emp = new Employee();
//		emp.setEmployeeId(922104);
//		emp.setEmployeeName("浅井　順二");
//		emp.setSection("開発部");
//		emp.setPhone("7712-4416");
//		expected.add(emp);
//
//		emp = new Employee();
//		emp.setEmployeeId(922105);
//		emp.setEmployeeName("高橋　道夫");
//		emp.setSection("営業部");
//		emp.setPhone("7712-3316");
//		expected.add(emp);
//
//		emp = new Employee();
//		emp.setEmployeeId(922106);
//		emp.setEmployeeName("夏木　裕子");
//		emp.setSection("営業部");
//		emp.setPhone("7712-3317");
//		expected.add(emp);
//
//		// assert
//		List<Employee> actual = sut.selectAll();
//
//		assertThat(expected).isEqualTo(actual);
//	}
//
//	@Test
//	@DatabaseSetup(type = DELETE_ALL)
//	@DisplayName("PT001_02_005:従業員情報のリストが取得できない場合（レコード0件）")
//	void testSelectAll_test2() {
//		// assert
//		assertThat(sut.selectAll()).isEmpty();
//	}
//
//	@Nested
//	@SpringBootTest
//	@DisplayName("PT001_02_006:DataAccessExceptionが発生する場合")
//	class MemberTableRenamed {
//
//		@BeforeEach
//		void setUp() throws Exception {
//			executeQueryForTestService.renameTable("employee", "employee2");
//		}
//
//		@AfterEach
//		void tearDown() throws Exception {
//			executeQueryForTestService.renameTable("employee2", "employee");
//		}
//
//		@Test
//		@DisplayName("従業員情報のリストの取得に失敗する")
//		void testSelectAll_test3() throws Exception {
//			// assert
//			assertThatThrownBy(() -> sut.selectAll())
//					.isInstanceOf(SqlExecutionException.class);
//		}
//	}
//}