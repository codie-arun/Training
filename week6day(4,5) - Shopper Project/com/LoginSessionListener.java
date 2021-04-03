package com;

import java.util.Properties;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginService;
import service.LoginServiceImpl;

/**
 * Application Lifecycle Listener implementation class LoginSessionListener
 *
 */

@WebListener
public class LoginSessionListener implements HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
        
    	
    	System.out.println("Session created");
    	
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	
    	System.out.println("Session destroyed");
    	
    	HttpSession session = se.getSession();
    	Properties prop = (Properties)session.getServletContext().getAttribute("prop");
    	LoginService loginService = LoginServiceImpl.getLoginServiceImpl(prop);
    	
    	Object un = session.getAttribute("uname");     	
    	if(un!=null){
    		String uname = (String)un;
    		loginService.updateFlag(uname, 0);
    	}
    }
	
}
