package week4day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo7 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Laddu laddu = new Laddu();
		System.out.println("original size : "+laddu.size );
		
		ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oops.writeObject(laddu);
		
		
		laddu.size = 5;
		System.out.println("size now: "+laddu.size );
		
		System.out.println("Retriving old Size");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2 = (Laddu)ois.readObject();
		
		System.out.println("Old size :  "+laddu2.size);
		System.out.println("New size :  "+laddu.size);
	}

}

class Laddu implements Serializable {
	
	public Laddu() {
		System.out.println("laddu created");
	}
	
	int size = 10;
}