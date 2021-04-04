package week5day2;

import java.time.LocalDate;

public class Crud {

	public static void main(String[] args) throws Exception{
		
//		CustomerDAOimpl cusdao = new CustomerDAOimpl();
//		CustomerDTO cust1 = cusdao.createCustomerDTO(101, "Arun", "ey", "arun@gmail.com", 90805);
//		CustomerDTO cust2 = cusdao.createCustomerDTO(102, "Balaji", "kct", "balaji@gmail.com", 89873);
//		
//		cusdao.insertCustomer(cust1);
//		cusdao.insertCustomer(cust2);
//		//cusdao.deleteCustomer(101);
//		System.out.println(cusdao.getCustomer(102));
//		System.out.println(cusdao.getAllCustomer());
//		CustomerDTO upcust2 = cusdao.createCustomerDTO(102, "Elon", "Tesla", "musk@gmail.com", 99999);
//		cusdao.updateCustomer(upcust2);
//		
//		
//		
//		InvoiceDAOimpl indao = new InvoiceDAOimpl();
//		InvoiceDTO inv1 = indao.createInvoiceDTO(201,LocalDate.now(),101);
//		InvoiceDTO inv2 = indao.createInvoiceDTO(202,LocalDate.now(),101);
//		InvoiceDTO inv3 = indao.createInvoiceDTO(203,LocalDate.now(),102);
//		InvoiceDTO inv4 = indao.createInvoiceDTO(204,LocalDate.now(),102);
//		
//		InvoiceDTO upinv1 = indao.createInvoiceDTO(201,LocalDate.now(),110);
//		indao.insertInvoice(inv1);
//		indao.insertInvoice(inv2);
//		indao.deleteInvoice(202);
//		indao.updateInvoice(upinv1);
//		System.out.println(indao.getInvoice(201));
//		System.out.println(indao.getAllInvoice());
//		
//		
//		
//		
//		
//		
//		ItemDAOimpl itemdao = new ItemDAOimpl();
//		ItemDTO item1 = itemdao.createItemDTO(11,"rice", 1, 50);
//		ItemDTO item2 = itemdao.createItemDTO(12,"biscuit", 1, 20);
//		ItemDTO item3 = itemdao.createItemDTO(13,"wheat", 1, 70);
//		ItemDTO item4 = itemdao.createItemDTO(14,"chicken", 1, 100);
//		
//		itemdao.insertItem(item1);
//		itemdao.insertItem(item2);
//		itemdao.insertItem(item3);
//		itemdao.insertItem(item4);
//		itemdao.deleteItem(11);
//		itemdao.deleteItem(12);
//		itemdao.deleteItem(13);
//		System.out.println(itemdao.getItem(14));
//		System.out.println(itemdao.getAllItem());
//		
//		ItemDTO upitem4 = itemdao.createItemDTO(14,"fish", 1, 900);
//		itemdao.updateItem(upitem4);
//		
//		
//		
//		
		TransactionDAOimpl transdao = new TransactionDAOimpl();
//		TransactionDTO t1 = transdao.createTransactionDTO(991, 14, 5);
//		TransactionDTO t2 = transdao.createTransactionDTO(992, 11, 10);
//		TransactionDTO t3 = transdao.createTransactionDTO(993, 12, 15);
//		TransactionDTO t4 = transdao.createTransactionDTO(994, 13, 20);
//		
//		transdao.insertTransaction(t1);
//		transdao.insertTransaction(t2);
//		transdao.insertTransaction(t3);
//		transdao.insertTransaction(t4);
//		
//		transdao.deleteTransaction(12);
//		transdao.deleteTransaction(14);
//		
		System.out.println(transdao.getTransaction(992));
//		System.out.println(transdao.getAllTransaction());
//		TransactionDTO upt4 = transdao.createTransactionDTO(994, 50, 100);
//		transdao.updateTransaction(upt4);
	}

}
