/**
 * TeamsMessageSendService.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.service;

/**
 * TeamsMessageSendServiceクラス
 * @author kuga
 * @version 1.0 2023/07/12
 *  */
public interface TeamsMessageService {

	/**
	 * メッセージ送信メソッド
	 * @param userId	TeamsユーザーID
	 * @param userName	ユーザー名
	 * @param title		メッセージタイトル
	 * @param message	メッセージ本文
	 * @param href		アンケートURL
	 * @return JSON
	 */
	public String createAdaptiveCardToJson(String userId,
			String userName,
			String title,
			String message,
			String href) ;
}
