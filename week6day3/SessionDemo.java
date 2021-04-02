package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer count = 0;
		HttpSession session = request.getSession();
		
		ServletOutputStream out = response.getOutputStream();
		
		Object sessionObj = session.getAttribute("count");
		if(sessionObj == null) {
	//	if(session.isNew()) {
			session.setAttribute("count", count);
			out.println("<h1>First time here</h1>");
		}else {
			out.println("<h1>Not First time here</h1>"+sessionObj);
			String s = sessionObj.toString();
			int x = Integer.parseInt(s);
			session.setAttribute("count", ++x);
		}
	}

	
}
