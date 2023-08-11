/**
 * Member.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.entity;

import java.io.Serializable;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import lombok.Data;

/**
 * Memberテーブルに対応するEntityクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Data
@Entity
public class Member implements Serializable {

	@Id
	private String memberId;
	private String password;
	private String memberName;
	private String gender;
	private String address;
	private String phone;
	private int memberPoint;
}
