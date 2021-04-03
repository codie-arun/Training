package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		int uno = Integer.parseInt( request.getParameter("uno") );
		String uname = request.getParameter("uname");
		String uaddress = request.getParameter("uaddress");
		String umail = request.getParameter("umail");
		int phone = 54145;
		String upass = request.getParameter("upass");
		
		Properties prop = (Properties)request.getServletContext().getAttribute("prop");
		
		LoginService loginService = LoginServiceImpl.getLoginServiceImpl(prop);
		
		loginService.registerUser(uno,  uname,  uaddress,  umail,  phone,  upass);
		
		return "register.success";
	}

	

}
