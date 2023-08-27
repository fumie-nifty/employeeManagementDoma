/**
 * ApplicationLogger.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common.logger;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * アプリケーションログ出力要件
 *   アクションに到達するリクエストがあったとき
 *  	AL-1 タイムスタンプ
 * 		AL-2 ログレベル
 * 		AL-3 ログカテゴリ
 * 		AL-4 スレッド名
 * 		AL-5 ユーザID
 * 		AL-6 HTTPメソッド(GETorPOST)
 * 		AL-7 コントローラ名
 * 		AL-8 メソッド名
 */

/**
 * ApplicationLoggerクラス
 * @author kuga
 * @version 1.0 2023/08/27
 */
public class AppLogger implements HandlerInterceptor {

	// ロガー
	private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

	/**
	 * コントローラー実行前の処理
	 * @param 	request	リクエストオブジェクト
	 * @param 	responseレスポンスオブジェクト
	 * @param 	handler	実行するために選択されたハンドラー
	 * @return 	true コントローラーの処理を実行
	 *         	false コントローラーの処理を実行せずに200のレスポンスを返す
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//静的リソースの場合はログ出力しない
		if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		//リクエストに紐づくコントローラーメソッドの取得
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		//認証されたユーザーの情報の取得
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		//ログ出力情報取得
		String controller = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		String httpRequest = request.getMethod();
		
		
		//オブジェクトの型がUserDetailsの時
		String userId = null;
		if (principal instanceof UserDetails) { 
			userId = ((UserDetails) principal).getUsername();
			
		} else { //UserDetails以外
			userId = principal.toString();
		}
		
		//出力メッセージの作成
		StringBuilder logMessage = new StringBuilder();		
		logMessage.append("[APLOG]");
		logMessage.append(" UserId:" + userId);
		logMessage.append(" HTTPmethod:" + httpRequest);
		logMessage.append(" Controller:" + controller);
		logMessage.append(" Method:" + methodName);
		
		//ログ出力
		logger.info(logMessage.toString());
		
		return true;
	}

	//コントローラー実行後の処理
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	//レスポンスを送信したあとの処理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
	}
}
