package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name = request.getParameter("name");
	      pw.println("<HTML>");
	      pw.println("<HEAD><TITLE>Hello "+name+"</TITLE></HEAD>");
	      pw.println("<BODY>");
	      pw.println("<H1>Hello, <BLINK>"+name+"</BLINK></H1>");
	      pw.println("</BODY>");
	      pw.println("</HTML>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}