/**
 * MemberDao.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import jp.co.flm.conf.ConfigAutowireable;
import jp.co.flm.entity.Member;

/**
 * Memberテーブルに対応するDaoインターフェース
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Dao
@ConfigAutowireable
public interface MemberDao {
	
	@Select
	Member selectByIdPass(String memberId,String password);

	@Select
	Member selectById(String memberId);
}
