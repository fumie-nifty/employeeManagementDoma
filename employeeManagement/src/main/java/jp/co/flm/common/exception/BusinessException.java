/**
 * BusinessException.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common.exception;

/**
 * BusinessExceptionクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}

}
