package service;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxXmlParser {

	
	public ArrayList<ArrayList<String>> parse(String file) throws Exception {
		SAXParserFactory spf =  SAXParserFactory.newDefaultInstance();
		SAXParser sp = spf.newSAXParser();
		
		MyXMLHandler hand = new MyXMLHandler();
		
		sp.parse(file, hand);
		
		return hand.getXmlObj();
	
	}
	
}


class MyXMLHandler extends DefaultHandler{
	
	
	
	
	
	ArrayList<String> details = new ArrayList<String>();
	ArrayList<ArrayList<String>> xmlobj = new ArrayList<ArrayList<String>>();
	
	int itemflag;
	ArrayList<String> list = new ArrayList<String>();
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}
	
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName == "item") {
			list = new  ArrayList<String>();
			itemflag = 1;
		}
		
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName == "item") {
			xmlobj.add(list);
			itemflag = 0;
		}
			
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String s=new String(ch,start,length);
		if(itemflag == 1) {
			list.add(s);
		}
		else {
			details.add(s);
		}
		
	}
	
	public ArrayList<ArrayList<String>> getXmlObj() {
		xmlobj.add(0,details);
	
		return xmlobj;
	}
}