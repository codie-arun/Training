package week7day3;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

	public static void main(String[] args) throws Exception {
		
		URL url=new URL("http://localhost:2020/ws/hello?wsdl");
		QName qName=new QName("http://week7day3/","HelloServiceImplService");
		
		Service service=Service.create(url,qName);
		
		HelloService hservice=service.getPort(HelloService.class);
		
		String result=hservice.sayHello("ramu");
		System.out.println("The result is..:"+result);
	}

}
