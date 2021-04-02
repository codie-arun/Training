package week7day3;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(endpointInterface = "week7day3.HelloService")
public class HelloServiceImpl implements HelloService{
	
	@WebMethod
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Welcome to SOAP based standard webservices....:"+name;
	}
}
