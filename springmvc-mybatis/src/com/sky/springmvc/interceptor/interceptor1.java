package com.sky.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class interceptor1 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����ǰ1");
		//�ж��û��Ƿ��½  ���û�е�½  �ض��򵽵�½ҳ��   ������   �����½��  �ͷ�����
				// URL  http://localhost:8080/springmvc-mybatis/login.action
				//URI /login.action
				String requestURI = request.getRequestURI();
				if(!requestURI.contains("/login")){
					String username = (String) request.getSession().getAttribute("USER_SESSION");
					if(null == username){
						response.sendRedirect(request.getContextPath() + "/login.action");
						return false;
					}
				}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������1");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ҳ����Ⱦ��1");
	}

	

	

	
}
