package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.XmlBuilder;

import service.ExcelCreatorService;
import service.ExcelCreatorServiceImpl;
import service.PdfCreatorService;
import service.PdfCreatorServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

public class ExcelAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Properties prop = (Properties)request.getServletContext().getAttribute("prop");
		ItemDAO itemdao = ItemDAOImpl.getItemDAOImpl(prop);
		ItemDTO itemDTO = new ItemDTO();
		HttpSession session = request.getSession();
		
		int i = 1;
		ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
		
		ProductService productService = ProductServiceImpl.getProductServiceImpl(prop);
		ExcelCreatorService excelCreatorService = ExcelCreatorServiceImpl.getExcelCreatorServiceImpl(prop);
		
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()){
			
			String name = e.nextElement();
			
			if(productService.isNumeric(name)) {
				
				
				try {
					ArrayList<String> al = new ArrayList<String>();
					itemDTO = itemdao.getItem(Integer.parseInt(name));
					al.add(Integer.toString(itemDTO.getItem_no()));
					al.add(itemDTO.getItem_name());
					al.add(Integer.toString(itemDTO.getItem_unit()));
					al.add(Integer.toString(itemDTO.getItem_price()));
					al.add(Integer.toString(1));
					al.add(Integer.toString(1*itemDTO.getItem_price()));
					
					items.add(al);
					
										
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}			
		}
		
		try {
			
			//pdfCreatorService.generatePdf(items, (String)session.getAttribute("uname"));
			XmlBuilder xmlfileBuilder = XmlBuilder.getXmlBuilder();
			String path = xmlfileBuilder.buildXml(items,(String)session.getAttribute("uname"));
			System.out.println(path);
			excelCreatorService.generateExcel("D:\\temp\\invoice.xml");
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		System.out.println(items);
		
		return "success";
	}
}
