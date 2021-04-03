package com;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.ItemDAO;
import model.ItemDAOImpl;
import model.ItemDTO;

public class PurchaseList extends TagSupport{
	
	String name;
	
	
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		JspWriter out=pageContext.getOut();
		HttpSession mysession = pageContext.getSession();
		
		Properties prop = (Properties)pageContext.getRequest().getServletContext().getAttribute("prop");
		ItemDAO itemdao = ItemDAOImpl.getItemDAOImpl(prop);
		ItemDTO itemDTO = new ItemDTO();
		int total = 0;
		Enumeration<String> e = mysession.getAttributeNames();
		while(e.hasMoreElements()){
			
			String name = e.nextElement();
			
			if(isNumeric(name)) {
				
				String value = (String)mysession.getAttribute(name);
				
				try {
					
					itemDTO = itemdao.getItem(Integer.parseInt(name));
					
					out.println("<h5>"+itemDTO.getItem_no()+" | "
					+itemDTO.getItem_name()+" - "
					+itemDTO.getItem_price()+"</h5>");
					
					total+=itemDTO.getItem_price();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}			
		}
		
		
		try {
			out.println("<h2>Gross Total Rs : "+ total +"/-</h2>");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return super.doEndTag();
	}
}
