package week7day3complex;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2020/ws/compempserv", new ComplexServiceImpl());
		System.out.println("service published");
	}
	

}
