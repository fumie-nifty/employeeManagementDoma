package jp.co.flm.dao;

//import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.flm.entity.Member;

/**
 * @author FLM
 * @version 1.0 yyyy/mm/dd
 */
@SpringBootTest
@DisplayName("PT001_01:MemberDaoのテスト")
public class MemberDaoTest01 {

	@Autowired
	MemberDao sut;

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
		//assertThat(actual).isEqualTo(expected);
		assertThat(actual,is(expected));

	}

}