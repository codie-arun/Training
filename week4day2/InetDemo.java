package week4day2;

import java.net.InetAddress;

public class InetDemo {

	public static void main(String[] args) throws Exception{
	
		InetAddress ineta = InetAddress.getByName("www.google.com");
		
		System.out.println(ineta.getHostAddress());
		
		
		InetAddress inetarr[] =  InetAddress.getAllByName("www.irctc.co.in");
		
		for(InetAddress i:inetarr) {
			System.out.println(i.getHostAddress());
		}
	}
	
}
