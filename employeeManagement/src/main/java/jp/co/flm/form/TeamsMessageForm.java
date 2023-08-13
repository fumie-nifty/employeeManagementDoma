/**
 * Employee.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Teamsメッセージを格納するFormクラス
 * @author kuga
 * @version 1.0 2023/08/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamsMessageForm implements Serializable{
	
	private String userId;
	private String userName;
	private String title;
	private String message;
	private String href;

}
