package com.sky.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * �쳣���������Զ����ʵ����
 * @author sky
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		// TODO Auto-generated method stub
		//obj  �����쳣�ĵط� Serivce��  ����  ����+����+���������βΣ� �ַ���
		//��־    1.���� tomcat war  Eclipse  2.����Tomcat  ��������  Linux  Log4j
		
		ModelAndView mav = new ModelAndView();
		//�ж��쳣Ϊ����
		if(e instanceof MessageException){
			//Ԥ���쳣
			MessageException me = (MessageException)e;
			mav.addObject("error", me.getMsg());
		}else{
			mav.addObject("error", "δ֪�쳣");
		}
		    mav.setViewName("error");
		
		return mav;
	}

}
