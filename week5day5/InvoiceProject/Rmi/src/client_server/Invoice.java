package client_server;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface Invoice extends Remote{
	
	public void startInvoiceApp()throws RemoteException;
//	public void createInvoice() throws Exception;
//	public void createPdf(int n) throws Exception;
	public LocalDateTime calculateDate(int distance,int speed,int ihours,int iminutes,int iseconds) throws Exception;
	public void insertNewItem(String name,int unit,int price) throws Exception;
	public void createInvoice(String name,int quantity) throws Exception;
	public int createNewCustomer(String name,String address,String email,int phone) throws Exception;
	public void createInvoiceRecord(int invoice_no,int customer_no) throws Exception;
	public void createPdf(int invoice_no) throws Exception;
}
