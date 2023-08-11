package jp.co.flm.common;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class PasswordEncoder {

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
