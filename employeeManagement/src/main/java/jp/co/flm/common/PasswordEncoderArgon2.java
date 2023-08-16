/**
 * PasswordEncoderArgon2.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

/**
 * PasswordEncoderArgon2クラス
 * @author kuga
 * @version 1.0 2023/08/15
 */
public class PasswordEncoderArgon2 {

    //Argon2でパスワードをハッシュ化するテスト
    public static void main(String[] args) {
        String passcode = toArgon(args[0]);
        System.out.println(passcode);
    }
    
    //Argon2でパスワードをハッシュ化
    public static String toArgon (String str) {
        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder();
        String passcode = argon2PasswordEncoder.encode(str);
        return passcode;
   	
    }
    
}
