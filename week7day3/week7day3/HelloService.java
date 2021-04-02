package week7day3;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
	public String sayHello(String name);
}
