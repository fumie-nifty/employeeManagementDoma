/**
 * MemberinfoService.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.flm.dao.MemberDao;
import jp.co.flm.entity.Member;
import jp.co.flm.service.dto.LoginUser;

/**
 * MemberinfoServiceクラス
 * ユーザ情報を取得し認証情報を作成するサービス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Service
public class MemberinfoService implements UserDetailsService{
	
	private final MemberDao memberDao;
	
	@Autowired
	public MemberinfoService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberDao.selectById(username);
		
		if(member==null) {
			throw new UsernameNotFoundException(username + "not found");
		}
		return new LoginUser(member);
	}

}
