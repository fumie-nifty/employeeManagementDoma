/**
 * 
 */
package jp.co.flm.common.logger;

import java.util.function.Supplier;

import org.seasar.doma.jdbc.AbstractJdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import ch.qos.logback.classic.Level;

/**
 * @author lisjxo
 *
 */
public class DbLogger extends AbstractJdbcLogger<Level>{
	private static final Logger logger = LoggerFactory .getLogger(DbLogger.class);

	public DbLogger() { 
		super(Level.INFO); 
	} 


	@Override
	public void logSql(String callerClassName, String callerMethodName, Sql<?> sql) { 
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = "anonymousUser";
        if(auth!=null) {
			Object principal = auth.getPrincipal();
			//オブジェクトの型がUserDetailsの時
			if (principal instanceof UserDetails) { 
				userId = ((UserDetails) principal).getUsername();
				
			} else { //UserDetails以外
				userId = principal.toString();
			}
        }

        String newSql = String.valueOf(sql);
        String arrangeSql = newSql.replace(System.getProperty("line.separator").toString(), "");
        
        logger.info("[DBLOG] sql:" + arrangeSql + " userId:" + userId);

	 }


	@Override
	protected void log(Level level, String callerClassName, String callerMethodName, Throwable throwable,
			Supplier<String> messageSupplier) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
