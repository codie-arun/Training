package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;

import model.CustomerDAO;
import model.CustomerDAOImpl;
import model.CustomerDTO;
import model.InvoiceDAO;
import model.InvoiceDAOImpl;
import model.InvoiceDTO;
import model.TransactionDAO;
import model.TransactionDAOimpl;
import model.TransactionDTO;

public class InvoiceServiceImpl implements InvoiceService{

	Properties prop;
	private static InvoiceServiceImpl invoiceServiceImpl;
	
		
	
	public InvoiceServiceImpl(Properties prop) {
		
		this.prop = prop;
	}
	
	public static InvoiceServiceImpl getInvoiceServiceImpl(Properties prop) {
		if(invoiceServiceImpl == null) {
			invoiceServiceImpl = new InvoiceServiceImpl(prop);
			return invoiceServiceImpl;
		}else {
			return invoiceServiceImpl.getClone();
		}
	}
	
	public InvoiceServiceImpl getClone() {
		try {
			return (InvoiceServiceImpl)super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	@Override
	public void updateInvoice(String cus_name,ArrayList<Integer> items) {
		
		CustomerDAO cusdao = CustomerDAOImpl.getCustomerDAOImpl(prop);
		CustomerDTO cusdto = cusdao.getCustomerByName(cus_name);
		
		InvoiceDTO invdto = new InvoiceDTO();
		
		invdto.setCustomer_no(cusdto.getCustomer_no());
		invdto.setInvoice_no(cusdto.getCustomer_no()*10);
		invdto.setInvoice_date(LocalDate.now());
		
		
		InvoiceDAO invdao = InvoiceDAOImpl.getInvoiceDAOImpl(prop);
		invdao.insertInvoice(invdto);
		
		
		TransactionDAO transdao = TransactionDAOimpl.getTransactionDAOimpl(prop);
		
		for(Integer i: items) {
			TransactionDTO transdto = new TransactionDTO();
			
			transdto.setInvoice_number(cusdto.getCustomer_no()*10);
			transdto.setItem_no(i);
			transdto.setQuantity(1);
			
			transdao.insertTransaction(transdto);
		}
		
		
	}
	
	
	
}
