package week4day1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlToExcel {

	public static void main(String[] args) throws Exception{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("bill.xml");
		
		Element rootElement = doc.getDocumentElement();
		
//		for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
//			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
//				System.out.println(rootElement.getChildNodes().item(i).getNodeName());
//			}
//		}
		
		System.out.println(doc.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
		
	}
}



class XmlData{
	
	
	
	Element rootElement;
	
	public XmlData(Element rootElement) throws Exception{
		
		this.rootElement = rootElement;
		
	}
	
	public void getCustomername() {
		
		NodeList node = rootElement.getChildNodes();
		System.out.println(node.item(0).getChildNodes().item(0).getNodeValue());
		
	}
	
	public String getBillNo() {
		return null;
	}
	
	public String getDate() {
		return null;
	}
	
}