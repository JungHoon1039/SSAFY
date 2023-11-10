package com.ssafy.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ws.model.UserDto;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

	// 컨트롤러 호출전에 실행되어야 하므로 preHandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthorizationInterceptor");
		HttpSession session = request.getSession();

		Object user = session.getAttribute("userinfo");
		if (user != null) {
			UserDto userDto = (UserDto) user;
			if (userDto.getUserRank() == 1) {
				return true;
			}
		}
		System.out.println("contextPath : " + request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/");
		return false;
	}
}
