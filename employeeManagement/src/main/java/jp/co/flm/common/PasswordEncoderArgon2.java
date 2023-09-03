/**
 * PasswordEncoderArgon2.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * PasswordEncoderArgon2クラス
 * Argon2PasswordEncoderを使用するサンプル
 * 
 * Argon2PasswordEncoderのコンストラクタにソルト値の指定はない、encode()メソッドでエンコードした時に
 * ソルト値が決まる
 * 
 * @author kuga
 * @version 1.0 2023/08/15
 */
public class PasswordEncoderArgon2 {

	//Argon2でパスワードをハッシュ化するテスト
	public static void main(String[] args) {
		
		String passcode = args[0];
		
		//Argon2PasswordEncoderオブジェクトのencodeメソッドを複数呼出し（毎回オブジェクト生成）
		System.out.println("encode01:");
		System.out.println(encode01(passcode));
		System.out.println("encode01:");
		System.out.println(encode01(passcode));
		
		PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder();
		
		if(argon2PasswordEncoder.matches("password", encode01(passcode))) {
			System.out.println("OK");
		}else {
			System.out.println("NG");
		}
		
		System.out.println();
		
		System.out.println("encode02:");
		System.out.println(encode02(passcode));
		
		//同一のArgon2PasswordEncoderオブジェクトのencodeメソッドを複数呼出し
		System.out.println(argon2PasswordEncoder.encode(passcode));
		System.out.println(argon2PasswordEncoder.encode(passcode));
		System.out.println(argon2PasswordEncoder.encode(passcode));
	}

	//コンストラクタ引数なし、初期値でArgon2でパスワードをハッシュ化
	public static String encode01(String str) {
		
		PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder();

		String passcode = argon2PasswordEncoder.encode(str);
		return passcode;

	}

	//ソルト長とハッシュの長さを初期値の倍にしてArgon2でパスワードをハッシュ化
	public static String encode02(String str) {

		int saltLength = 32; //ソルトの長さ (バイト単位) 初期値：16
		int hashLength = 64; //ハッシュの長さ (バイト単位) 初期値：32
		int parallelism = 1; //平行度 初期値：1
		int memory = 1 << 12; //メモリコスト 初期値：1 << 12
		int iterations = 5; //反復回数 初期値：3

		PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
		
		String passcode = argon2PasswordEncoder.encode(str);
		return passcode;

	}

}
