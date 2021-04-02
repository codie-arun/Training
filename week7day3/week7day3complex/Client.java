package week7day3complex;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class Client {

	public static void main(String[] args) throws MalformedURLException {
	
		
		URL url = new URL("http://localhost:2020/ws/compempserv?wsdl");
		QName qname = new QName("http://week7day3complex/","ComplexServiceImplService");
		Service service = Service.create(url,qname);
		ComplexService cs = service.getPort(ComplexService.class);
		
		Employee e1 = new Employee(5,"mark",1122);
		Employee e2 = new Employee(6,"marshal",1412);
		Employee e3 = new Employee(7,"wiki",112002);
		
		cs.setAllEmployees(Arrays.asList(e1,e2,e3));
		
		System.out.println(cs.getAllEmployees());
		
//		List<Employee> emp = cs.getAllEmployees();
//		
//		System.out.println(emp);
		
//		Service service = Service.create(url,qname);
//		Hello hello = service.getPort(Hello.class);
		
	}

}
