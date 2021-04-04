package client_server;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

import consignment_tracker.BreakInterval;
import consignment_tracker.Estimator;
import consignment_tracker.Tracker;
import database.CustomerDAOimpl;
import database.CustomerDTO;
import database.InvoiceDAOimpl;
import database.InvoiceDTO;
import database.ItemDAOimpl;
import database.ItemDTO;
import database.TransactionDAOimpl;
import database.TransactionDTO;
import filebuilders.FileBuilder;
import filebuilders.PdfFileBuilder;

public class InvoiceServer extends UnicastRemoteObject implements Invoice{
	
	static int item_no = 1;
	static int customer_no = 100;
	static int invoice_no = 1000;
	
	public InvoiceServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void startInvoiceApp() throws RemoteException {
		System.out.println("Invoice started");
	}
	
	@Override
	public int createNewCustomer(String name,String address,String email,int phone) throws Exception {
		// TODO Auto-generated method stub
		CustomerDAOimpl cusdao = new CustomerDAOimpl();
		CustomerDTO cust = cusdao.createCustomerDTO(++InvoiceServer.customer_no, name, address, email, phone);
		cusdao.insertCustomer(cust);
		return InvoiceServer.customer_no;
	}
	
	@Override
	public void createInvoice(String name,int quantity) throws Exception {
		// TODO Auto-generated method stub
		TransactionDAOimpl transdao = new TransactionDAOimpl();
		ItemDAOimpl itemdao = new ItemDAOimpl();
		
		TransactionDTO transaction = transdao.createTransactionDTO(InvoiceServer.invoice_no, itemdao.getItemNo(name), quantity);
		transdao.insertTransaction(transaction);
	}
	
	@Override
	public void createInvoiceRecord(int invoice_no, int customer_no) throws Exception {
		// TODO Auto-generated method stub
		InvoiceDAOimpl invdao = new InvoiceDAOimpl();
		InvoiceDTO invoice = invdao.createInvoiceDTO(invoice_no, LocalDate.now(), customer_no);
		invdao.insertInvoice(invoice);
	}
	
	public LocalDateTime calculateDate(int distance,int speed,int ihours,int iminutes,int iseconds) throws Exception {

	    Tracker tracker = new Estimator(LocalDateTime.now(), distance, speed, new BreakInterval(ihours,iminutes,iseconds));
	    return tracker.getDeliveryDateAndTime();
	    
	}
	
	@Override
	public void insertNewItem(String name, int unit, int price) throws Exception {
		ItemDAOimpl itemdao = new ItemDAOimpl();
		ItemDTO item = itemdao.createItemDTO(InvoiceServer.item_no++, name, unit, price);
		itemdao.insertItem(item);
	}
	
//	public void createInvoice() throws Exception{
//		CustomerDAOimpl cusdao = new CustomerDAOimpl();
//		InvoiceDAOimpl indao = new InvoiceDAOimpl();
//		ItemDAOimpl itemdao = new ItemDAOimpl();
//		TransactionDAOimpl transdao = new TransactionDAOimpl();
//		cusdao.insertCustomer(cusdao.createCustomerDTO(100,"Bucky","DC","bucky@gmail.com",98765));
//		indao.insertInvoice(indao.createInvoiceDTO(202,LocalDate.now(),100));
//		itemdao.insertItem(itemdao.createItemDTO(20,"chicken",1,120));
//		transdao.insertTransaction(transdao.createTransactionDTO(202, 20, 10));
//	}
//	
	@Override
	public void createPdf(int invoice_no) throws Exception{
		
		TransactionDAOimpl transdao = new TransactionDAOimpl();
		InvoiceDAOimpl indao = new InvoiceDAOimpl();
		ItemDAOimpl itemdao = new ItemDAOimpl();
		CustomerDAOimpl cusdao = new CustomerDAOimpl();
		
		int total = 0; 
		
		ItemDTO item;
		
		InvoiceDTO inv = indao.getInvoice(invoice_no);
		CustomerDTO cust = cusdao.getCustomer(inv.getCustomer_no());
		
		System.out.println(cust);
		
		Set<TransactionDTO> tlist = transdao.getMyTransaction(invoice_no);
		
		StringBuilder xml = new StringBuilder();
		xml.append("<!DOCTYPE bill SYSTEM \"bill.dtd\">");
		xml.append("<bill>");
		xml.append("<customername>");
		xml.append(cust.getCustomer_name());
		xml.append("</customername>");
		xml.append("<billno>");
		xml.append(invoice_no);
		xml.append("</billno>");
		xml.append("<billdate>");
		xml.append(inv.getInvoice_date().toString());
		xml.append("</billdate>");
		xml.append("<items>");
		
		
		for(TransactionDTO t: tlist) {
			item = itemdao.getItem(t.getItem_no());
			System.out.println(item);
			
			xml.append("<item>");
			xml.append("<slno>");
			xml.append(item.getItem_no());
			xml.append("</slno>");
			xml.append("<itemname>");
			xml.append(item.getItem_name());
			xml.append("</itemname>");
			xml.append("<unit>");
			xml.append(item.getItem_unit());
			xml.append("</unit>");
			xml.append("<price>");
			xml.append(item.getItem_price());
			xml.append("</price>");
			xml.append("<qty>");
			xml.append(t.getQuantity());
			xml.append("</qty>");
			xml.append("<amount>");
			xml.append(t.getQuantity()*item.getItem_price());
			xml.append("</amount>");
			xml.append("</item>");
			
			total = total+t.getQuantity()*item.getItem_price();
		}
		
		xml.append("</items>");
		xml.append("<total>");
		xml.append(total);
		xml.append("</total>");
		xml.append("</bill>");
		
	
		
		System.out.println(xml);
		String s = xml.toString();
		
		
		try {
		      FileWriter myWriter = new FileWriter("newbill.xml");
		      myWriter.write(s);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		FileBuilder f = new PdfFileBuilder();
		f.buildFile("newbill");
	}
}
