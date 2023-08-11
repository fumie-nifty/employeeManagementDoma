/**
 * DataSourceConfiguration.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataSourceConfigurationコンフィグレーションクラス
 * MySQL接続設定
 * @author kuga
 * @version 1.0 2023/07/12
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

	@Autowired
	private DataSourceProperties properties;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(properties.getDriverClassName());
		dataSource.setUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		return new TransactionAwareDataSourceProxy(dataSource);
	}
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public Dialect dialect() {
		return new MysqlDialect();
	}

	@Bean
	public SqlFileRepository sqlFileRepository() {
		return new NoCacheSqlFileRepository();
	}

	@Bean
	public Config config() {
		return new Config() {
			@Override
			public Dialect getDialect() {
				return dialect();
			}

			@Override
			public DataSource getDataSource() {
				return dataSource();
			}

			@Override
			public SqlFileRepository getSqlFileRepository() {
				return sqlFileRepository();
			}
		};
	}
}
