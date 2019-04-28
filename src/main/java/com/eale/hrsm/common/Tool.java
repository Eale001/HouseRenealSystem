package com.eale.hrsm.common;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class Tool {

	public static  <T>T getBean(Class<T> clazz, HttpServletRequest request) {
		WebApplicationContext wc=   WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		return wc.getBean(clazz);
	}
}
