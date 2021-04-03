package com;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlBuilder implements Cloneable{
	
	private static XmlBuilder xmlBuilder;
	
	private XmlBuilder() {
		
	}
	
	public static synchronized XmlBuilder getXmlBuilder() {
		if(xmlBuilder == null) {
			xmlBuilder = new XmlBuilder();
			return xmlBuilder;
		}else {
			return xmlBuilder.getClone();
		}
	}
	
	
	public XmlBuilder getClone() {
		try {
			return (XmlBuilder)super.clone();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public String buildXml(ArrayList<ArrayList<String>> purchase_items,String customer_name) {
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.newDocument();
			
		    LocalDate date = LocalDate.now();
		    
		    
		    
		    Element rootElement = doc.createElement("invoice");
	        doc.appendChild(rootElement);
	        
	        Element invno = doc.createElement("invno");
	        invno.appendChild(doc.createTextNode(date.getDayOfMonth()+""+date.getMonthValue()+""+date.getDayOfWeek().getValue()));
	        
	        Element invdate = doc.createElement("invdate");
	        invdate.appendChild(doc.createTextNode(date.toString()));
	        
	        Element customername = doc.createElement("customername");
	        customername.appendChild(doc.createTextNode(customer_name));
	        
	        Element items = doc.createElement("items");
	        
	        Element gst = doc.createElement("gst");
	        
	        
	        Element net = doc.createElement("net");
	        
	        
	        rootElement.appendChild(invno);
	        rootElement.appendChild(invdate);
	        rootElement.appendChild(customername);
	        rootElement.appendChild(items);
	        rootElement.appendChild(gst);
	        rootElement.appendChild(net);
	        
	        int gst_value;
	        int net_value = 0;
	        
	        for(ArrayList<String> pitem: purchase_items) {
	        	
	        	Element item = doc.createElement("item");
	        	
	        	Element itemno = doc.createElement("itemno");
	        	itemno.appendChild(doc.createTextNode(pitem.get(0)));
	        	
	        	Element itemname = doc.createElement("itemname");
	        	itemname.appendChild(doc.createTextNode(pitem.get(1)));
	        	
	        	Element itemprice = doc.createElement("itemprice");
	        	itemprice.appendChild(doc.createTextNode(pitem.get(3)));
	        	
	        	Element itemqty = doc.createElement("itemqty");
	        	itemqty.appendChild(doc.createTextNode(pitem.get(4)));
	        	
	        	Element amount = doc.createElement("amount");
	        	amount.appendChild(doc.createTextNode(pitem.get(5)));
	        	
	        	item.appendChild(itemno);
	        	item.appendChild(itemname);
	        	item.appendChild(itemprice);
	        	item.appendChild(itemqty);
	        	item.appendChild(amount);
	        	
	        	items.appendChild(item);
	        	
	        	net_value = net_value+Integer.parseInt(pitem.get(5));
	        }
		    
	        gst_value =  net_value/10;
	        net_value = net_value+gst_value;
	        
	        gst.appendChild(doc.createTextNode(gst_value+""));
	        net.appendChild(doc.createTextNode(net_value+""));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\temp\\invoice.xml"));
			transformer.transform(source, result);
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "D:\\temp\\invoice.xml";
		
	}

}
