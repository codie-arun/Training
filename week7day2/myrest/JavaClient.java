package myrest;

import java.net.URL;
import java.net.URLConnection;

public class JavaClient {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:2020/myRest/rest/test");
		
		URLConnection urlcon =  url.openConnection();
		urlcon.getInputStream();
		
	}

}
