/**
 * ExecuteQueryForTestService.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.test.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

/**
 * @author FLM
 * @version 1.0 yyyy/mm/dd
 */
@Component
public class ExecuteQueryForTestService {

	private static final String SCRIPT = "/AllTest/data.sql";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void renameTable(String before, String after)
			throws RuntimeException {
		jdbcTemplate.update("RENAME TABLE " + before + " TO " + after + ";");
	}

	public void tearDown() {
		ResourceDatabasePopulator resourceDatabasePopulator
			= new ResourceDatabasePopulator();
		resourceDatabasePopulator
			.addScript(new ClassPathResource(SCRIPT, getClass()));
		resourceDatabasePopulator.setSqlScriptEncoding("UTF-8");
		resourceDatabasePopulator.setIgnoreFailedDrops(true);
		resourceDatabasePopulator.setContinueOnError(false);
		resourceDatabasePopulator
			.populate(
				DataSourceUtils.getConnection(jdbcTemplate.getDataSource()));
	}
}
