package high_performance.yuna.session;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SessionManager {
	public static final String SESSION_COOKIE_NAME = "mySessionId";
	private Map<String, Object> sessionStore = new ConcurrentHashMap<>();
	
	// 세션 생성 메서드
	public void createSession(Object value, HttpServletResponse response) {
		
		// 세션 id 생성하고 값을 세션에 저장함
		String serssionId = UUID.randomUUID().toString();
		sessionStore.put(serssionId, value);
		
		log.info("serssionId={}", serssionId);
		log.info("sessionStore.get(serssionId)={}", sessionStore.get(serssionId));
		
		// 쿠키 생성
		Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, serssionId);
		
		log.info("mySessionCookie.getName={}",mySessionCookie.getName());
		log.info("mySessionCookie.getValue={}",mySessionCookie.getValue());
		response.addCookie(mySessionCookie);
	}
	
	// 세션 조회
	public Object getSession(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
		
		if(sessionCookie == null) {
			return null;
		}
		
		return sessionStore.get(sessionCookie.getValue());
	}
	
	// 세션 만료
	public void expire(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
		
		log.info("sessionCookie{}",sessionCookie);
		
		if(sessionCookie != null) {
			sessionStore.remove(sessionCookie.getValue());
			log.info("sessionCookie{}",sessionCookie.getValue());
		}
		
	}
		
	
	// 쿠키 조회 메서드
	private Cookie findCookie(HttpServletRequest request, String cookieName) {
		if(request.getCookies() == null) {
			return null;
		}
		
		return Arrays.stream(request.getCookies())
				.filter(cookie -> cookie.getName().equals(cookieName))
				.findAny()
				.orElse(null);
	}
	
}
