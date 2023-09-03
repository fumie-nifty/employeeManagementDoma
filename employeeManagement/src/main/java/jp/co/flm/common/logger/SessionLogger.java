/**
 * SessionLogger.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.common.logger;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * SessionLoggerクラス
 * セッションの状態を確認するためのクラス
 * @author kuga
 * @version 1.0 2023/08/27
 */
public class SessionLogger implements HandlerInterceptor {

	// ロガー
	private static final Logger logger = LoggerFactory.getLogger(SessionLogger.class);

	/**
	 * コントローラー実行前にログ出力をする
	 * @param 	request	リクエストオブジェクト
	 * @param 	responseレスポンスオブジェクト
	 * @param 	handler	実行するために選択されたハンドラー
	 * @return 	true コントローラーの処理を実行
	 *         	false コントローラーの処理を実行せずに200のレスポンスを返す
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		return true;
	}

	//コントローラー実行後の処理
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {


		//リクエストに紐づくコントローラーメソッドの取得
		if(!(handler instanceof HandlerMethod)) {
			return;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		//ログ出力情報取得
		String controller = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		String httpRequest = request.getMethod();
		String sessionId = null;
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			sessionId = session.getId();
		}
		
		//出力メッセージの作成
		StringBuilder logMessage = new StringBuilder();		
		logMessage.append("【SESSIONLOG】");
		logMessage.append(" HTTPmethod:" + httpRequest);
		logMessage.append(" Controller:" + controller);
		logMessage.append(" Method:" + methodName);
		logMessage.append(" sessionId:" + sessionId);
		
		//ログ出力
		logger.info(logMessage.toString());

	}

	//レスポンスを送信したあとの処理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
	}
}
