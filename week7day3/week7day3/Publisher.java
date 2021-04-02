package week7day3;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2020/ws/hello", new HelloServiceImpl());
		System.out.println("service published");
	}
	

}
