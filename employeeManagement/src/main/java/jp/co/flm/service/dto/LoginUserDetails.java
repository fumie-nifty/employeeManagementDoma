package jp.co.flm.service.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.flm.entity.Member;

/**
 * LoginUserDetailsクラス（ UserDetailsを実装したクラス）
 * 認証情報（認証対象のユーザ情報）を格納するDTO
 * @author kuga
 * @version 1.0 2023/07/12
 */
public class LoginUserDetails implements UserDetails{
	
	//DBから取得したメンバー情報
	private final Member member;
	
	//権限リスト
	private final Collection<? extends GrantedAuthority> authorities;
	
	
	/**
	 * コンストラクタ。メンバー情報を元に認証情報を作成する。
	 * @param member		メンバー情報
	 */
	public LoginUserDetails(Member member) {
		this.member = member;
		this.authorities = new ArrayList<GrantedAuthority>();
	}

	/**
	 * コンストラクタ。メンバー情報とロールリストを元に認証情報を作成する。
	 * @param member		メンバー情報
	 * @param authorities	ロールリスト
	 */
	public LoginUserDetails(Member member,
					Collection<? extends GrantedAuthority> authorities) {
		this.member = member;
		this.authorities = authorities;
	}

	/**
	 * ロールリストを返す
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	
	/**
	 * メンバー情報を返す
	 * @return
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * パスワードを返す
	 * @return
	 */
	@Override
	public String getPassword() {
		return member.getPassword();
	}

	/**
	 * ユーザー名（メンバーID）を返す
	 * @return
	 */
	@Override
	public String getUsername() {
		return member.getMemberId();
	}

	/**
	 * メンバー名を返す
	 * @return
	 */
	public String getMemberName() {
		return member.getMemberName();
	}
	
	/**
	 * アカウントの有効期限の状態を返す。
	 * @return	true	有効期限内
	 * 			false	有効期限外
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * アカウントのロック状態を判定する。
	 * @return	true	ロックされていない
	 * 			false	ロック状態
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 資格情報（パスワード）の有効期限の状態を返す。
	 * @return	true	有効期限内
	 * 			false	有効期限外
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 有効なユーザーか判断する
	 * @return	true	有効
	 * 			false	無効
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
