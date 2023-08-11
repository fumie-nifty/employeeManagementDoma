package jp.co.flm.dao;

import static com.github.springtestdbunit.annotation.DatabaseOperation.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import jp.co.flm.entity.Member;
import jp.co.flm.test.util.ExecuteQueryForTestService;

/**
 * @author FLM
 * @version 1.0 yyyy/mm/dd
 */
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:AllTest/setupDB.xml")
@DatabaseTearDown("classpath:AllTest/setupDB.xml")
@DisplayName("PT001_01:MemberDaoのテスト")
public class MemberDaoTest {

	@Autowired
	MemberDao sut;

	@Autowired
	ExecuteQueryForTestService executeQueryForTestService;
	

	@Test
	@DisplayName("PT001_01_001：メンバーが検索できる場合")
	void testSelectByIdPass_test1() {
		// setup
		String testArg_memberId = "test1";
		String testArg_password = "$argon2id$v=19$m=16,t=2,p=1$UXptdXJxdk9QMTRic1psbw$8RlOZ4Yi/I9e1FYM9kD2jg";
		
		Member expected = new Member();
		expected.setMemberId("test1");
		expected.setPassword("$argon2id$v=19$m=16,t=2,p=1$UXptdXJxdk9QMTRic1psbw$8RlOZ4Yi/I9e1FYM9kD2jg");
		expected.setMemberName("飯田 哲夫");
		expected.setGender("M");
		expected.setAddress("東京都 大田区 池上0-0-0");
		expected.setPhone("03-1111-2222");
		expected.setMemberPoint(652);

		// assert
		Member actual = sut.selectByIdPass(testArg_memberId, testArg_password); 
		assertThat(actual).isEqualTo(expected);

	}

	@Test
	@DisplayName("PT001_01_002：メンバーが検索できない場合（存在しないパスワード）")
	void testSelectByIdPass_test2() {
		// setup
		String testArg_memberId = "test1";
		String testArg_password = "flm456";

		// assert
		Member actual = sut.selectByIdPass(testArg_memberId, testArg_password); 
		assertThat(actual).isNull();
	}

	@Test
	@DatabaseSetup(type = DELETE_ALL)
	@DisplayName("PT001_01_003：メンバーが検索できない場合（レコード０件）")
	void testSelectByIdPass_test3() {
		// setup
		String testArg_memberId = "test1";
		String testArg_password = "password";

		// assert
		Member actual = sut.selectByIdPass(testArg_memberId, testArg_password); 
		assertThat(actual).isNull();
	}

	@Nested
	@SpringBootTest
	@DisplayName("PT001_03_003:DataAccessExceptionが発生する場合")
	class MemberTableRenamed {

		@BeforeEach
		void setUp() throws Exception {
			executeQueryForTestService.renameTable("member", "member2");
		}

		@AfterEach
		void tearDown() throws Exception {
			executeQueryForTestService.renameTable("member2", "member");
		}

		@Test
		@DisplayName("メンバーが検索に失敗する")
		void testSelectByIdPass_test4() throws Exception {
			// setup
			String testArg_memberId = "test1";
			String testArg_password = "password";

			// assert
			assertThatThrownBy(() -> sut.selectByIdPass(testArg_memberId, testArg_password))
					.isInstanceOf(SqlExecutionException.class);
		}
	}
}