package client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;
public class InvoiceClient {
	public static void main(String[] args) throws Exception{
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please select your choice...");
		System.out.println("1-Create new Invoice");
		System.out.println("2-Create Pdf of Invoice");
		System.out.println("3-Calculate Delivery date and time");
		System.out.println("4-Insert New Item");
		
		inv.startInvoiceApp();
		
		System.out.println("Thank you");
		
		int choice=scan.nextInt();
		
		switch(choice) {
		case 1:{
			System.out.println("Are you already a customer");
			System.out.println("Y - Yes            N - No");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			
			if(reader.readLine().equals("N")) {
				System.out.println("Enter your name");
			    String name = reader.readLine();
			    
			    System.out.println("Enter your address");
			    String address = reader.readLine();
			    
			    System.out.println("Enter your email");
			    String email = reader.readLine();
			    
			    System.out.println("Enter your contact number");
			    int phone = Integer.parseInt(reader.readLine());
			    
			    System.out.println("Your Customer number is : "+inv.createNewCustomer(name,address,email,phone));
			}
			System.out.println("Entr your customer number");
			int cus_no = Integer.parseInt(reader.readLine());
			boolean i = true;
			System.out.println("Enter the item name and Quantity");
			System.out.println("Type 'done' when you are done");
			
			while(i) {
				String name = reader.readLine();
				if(name.equals("done")) {
					inv.createInvoiceRecord(InvoiceServer.invoice_no,cus_no);
					InvoiceServer.invoice_no++;
					break;
				}
					
				int quantity = Integer.parseInt(reader.readLine());
				
				inv.createInvoice(name,quantity);
			}
			
			break;
		}
		case 2:{
			System.out.println("Enter your invoice number");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    int invoice_no = Integer.parseInt(reader.readLine());
			inv.createPdf(invoice_no);
			break;
		}
		case 3:{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter the distance");
		    int distance = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the speed");
		    int speed = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval hours");
		    int ihours = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval minutes");
		    int iminutes = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval seconds");
		    int iseconds = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Estimated Arrival Time : "+
		    		inv.calculateDate(distance,speed,ihours,iminutes,iseconds));
		    break;
		}
		case 4:{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter the Item name");
		    String name = reader.readLine();
		    
		    System.out.println("Enter the unit");
		    int unit = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the item price");
		    int price = Integer.parseInt(reader.readLine());
			
			inv.insertNewItem(name, unit, price);
			break;
		}
		default:
			System.out.println("wrong choice...");
		}
		
	}
}
