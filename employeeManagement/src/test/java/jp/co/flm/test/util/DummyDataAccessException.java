/**
 * DuumyDataAccessException.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.test.util;

import org.springframework.dao.DataAccessException;

/**
 * @author FLM
 * @version 1.0 yyyy/mm/dd
 */
public class DummyDataAccessException extends DataAccessException {

	public DummyDataAccessException() {
		super(null);
	}
}
