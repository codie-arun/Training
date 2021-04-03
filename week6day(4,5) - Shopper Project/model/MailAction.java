package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MailService;
import service.MailServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

public class MailAction extends Action{

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Properties prop = (Properties)request.getServletContext().getAttribute("prop");
		MailService mailService = MailServiceImpl.getMailServiceImpll(prop);
		
		mailService.sendMail();
		
		return "success";
	}
	
}
