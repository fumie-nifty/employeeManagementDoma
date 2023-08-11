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
 * 認証情報（認証対象のユーザ情報）を格納するDTO
 * @author kuga
 * @version 1.0 2023/07/12
 */
public class LoginUser extends User {
	
	private static final long serialVersionUID =1L;
	/**
	 * 画面表示用メンバー名
	 */
	private String username;
	
	public LoginUser(Member member) {
		super(	member.getMemberId(),	//username - ユーザ名
				member.getPassword(),	//username - パスワード
				true,					//enabled - ユーザーが有効になっている場合は true に設定
				true,					//accountNonExpired - アカウントの有効期限が切れていない場合は true に設定
				true,					//credentialsNonExpired - 資格情報の有効期限が切れていない場合は、true に設定されます
				true,					//accountNonLocked - アカウントがロックされていない場合は true に設定
				new ArrayList<GrantedAuthority>()	// 正しいユーザー名とパスワードを提示し、ユーザーが有効になっている場合に呼び出し元に付与する必要がある権限
				);
		username = member.getMemberName();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
