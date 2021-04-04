package week4day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo1 {

	public static void main(String[] args) {
		new CopyCommand().copy("abcd.properties");
	}
	
}

class CopyCommand{
	
	public void copy(String filename) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			
			//fis = new FileInputStream(filename);
			//fos = new FileOutputStream("copyabc.properties");
			
			reader = new FileReader(filename);
			writer = new FileWriter("copyabc.properties");
			
//			int no_of_bytes_read;
//			byte b[] = new byte[8];
//			System.out.println("No of bytes : "+fis.available());
//			while((no_of_bytes_read = fis.read(b))!=-1) {
//				String s = new String(b,0,no_of_bytes_read);
//				System.out.println(s);
//				System.out.println("loop");
//				fos.write(b, 0, no_of_bytes_read);
//			}
			
			int no_of_char_read;
			char c[] = new char[8];
			//System.out.println("No of bytes : "+fis.available());
			while((no_of_char_read = reader.read(c))!=-1) {
				String s = new String(c,0,no_of_char_read);
				System.out.println(s);
				System.out.println("loop");
				writer.write(c, 0, no_of_char_read);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
//				fis.close();
//				fos.close();
				
				reader.close();
				writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
}
