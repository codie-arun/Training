package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.InvoiceService;
import service.InvoiceServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

public class InvoiceAction extends Action{


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Integer> items = new ArrayList<Integer>();
		
		Properties prop = (Properties)request.getServletContext().getAttribute("prop");
		InvoiceService invoiceService = InvoiceServiceImpl.getInvoiceServiceImpl(prop);
		ProductService productService = ProductServiceImpl.getProductServiceImpl(prop);
		
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()){
			
			String name = e.nextElement();
			if(productService.isNumeric(name)) {
				items.add(Integer.parseInt(name));
			}
		}
		
		
		
		invoiceService.updateInvoice((String)session.getAttribute("uname"),items);
		
		
		return "invoice";
	
	}
	

}





