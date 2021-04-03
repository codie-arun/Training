package com;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.CustomerDAO;
import model.ItemDAO;
import model.ItemDAOImpl;
import model.ItemDTO;
import service.ProductService;
import service.ProductServiceImpl;

public class Item extends TagSupport{

	private String category;


	public final String getCategory() {
		return category;
	}


	public final void setCategory(String category) {
		this.category = category;
	}



	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		JspWriter out=pageContext.getOut();
		
		Properties prop = (Properties)pageContext.getRequest().getServletContext().getAttribute("prop");
		ItemDAO itemdao = ItemDAOImpl.getItemDAOImpl(prop);
		Set<ItemDTO> itemdto = itemdao.getAllItemOfCategory(category);
		
		try {
			
			Iterator<ItemDTO> itemset = itemdto.iterator();
		     while(itemset.hasNext()){
		    	 
		    	 ItemDTO i = itemset.next();
		    	 
		    	 out.println(
		    	i.getItem_name()
		    	+":<input type=\"checkbox\" name=\""+i.getItem_no()
		    	+"\" value=\""+i.getItem_name()+"\"><br>");
		     }
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return super.doEndTag();
	}
	
	
}
