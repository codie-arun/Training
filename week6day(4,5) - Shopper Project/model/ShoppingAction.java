package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.ProductService;
import service.ProductServiceImpl;

public class ShoppingAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String category = request.getParameter("category");
		
		System.out.println(category);
		
		Properties prop = (Properties)request.getServletContext().getAttribute("prop");
		ProductService productService = ProductServiceImpl.getProductServiceImpl(prop);
		
		System.out.println(productService.showItems(category));
		
		
		return "shop.success";
	}

}
