/**
 * LoginUser.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service.dto;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.co.flm.entity.Member;

/**
 * LoginUserクラス
 * 認証情報（認証対象のユーザ情報）を格納するDTO（使用とりやめ）
 * @author kuga
 * @version 1.0 2023/07/12
 */
public class LoginUser extends User {
	
	private static final long serialVersionUID =1L;
	/**
	 * 画面表示用メンバー名
	 */
	private String memberName;
	
	/**
	 * @param member
	 */
	public LoginUser(Member member) {
		/**
		 * username - ユーザ名
		 * username - パスワード
		 * enabled - ユーザーが有効になっている場合は true に設定
		 * accountNonExpired - アカウントの有効期限が切れていない場合は true に設定
		 * credentialsNonExpired - 資格情報（パスワード）の有効期限が切れていない場合は、true に設定されます
		 * accountNonLocked - アカウントがロックされていない場合は true に設定
		 * authorities - 権限リスト
		 */
		super(	member.getMemberId(),				//username
				member.getPassword(),				//username
				true,								//enabled
				true,								//accountNonExpired
				true,								//credentialsNonExpired
				true,								//accountNonLocked
				new ArrayList<GrantedAuthority>()	// authorities
				);
		memberName = member.getMemberName();
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
}
