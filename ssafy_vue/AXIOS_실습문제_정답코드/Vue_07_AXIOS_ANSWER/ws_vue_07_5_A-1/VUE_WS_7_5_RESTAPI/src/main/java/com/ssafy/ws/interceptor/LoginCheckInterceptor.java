package com.ssafy.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	// 컨트롤러 호출전에 실행되어야 하므로 preHandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 세션에 로그인 정보가 있다면 그대로 진행한다.
		String nextURI = request.getRequestURI();
		if(session.getAttribute("userinfo") != null) {
			return true;
		}else{
			// 세션에 로그인 정보가 없다면, 진행을 멈추고 로그인화면으로 리다이렉트 그전에 진행중이던 경로에 대해서 저장
//			session.setAttribute("next",nextURI);
//			response.sendRedirect(request.getContextPath() + "/user/login");
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
	}
	
}
