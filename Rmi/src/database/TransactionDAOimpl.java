package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TransactionDAOimpl implements TransactionDAO{
	
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	
	
	public TransactionDAOimpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost/purchase","root","arun");
		this.st = st = con.createStatement();
	}
	
	public TransactionDTO createTransactionDTO(int invoice_number,int item_no,int quantity) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setInvoice_number(invoice_number);
		transactionDTO.setItem_no(item_no);;
		transactionDTO.setQuantity(quantity);;
		
		return transactionDTO;
	}
	
	@Override
	public int insertTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		
		try {
			
//			System.out.println(customerDTO.getCustomer_no());
//			System.out.println(customerDTO.getCustomer_name());
//			System.out.println(customerDTO.getCustomer_address());
//			System.out.println(customerDTO.getCustomer_email());
//			System.out.println(customerDTO.getCustomer_phone());
			
			st.execute("insert into transaction values("+transactionDTO.getInvoice_number()
					+","+transactionDTO.getItem_no()
					+","+transactionDTO.getQuantity()
					+")");
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		
		try {
			st.executeUpdate("update transaction set "
					+"item_no ="+transactionDTO.getItem_no()
					+",quantity ="+transactionDTO.getQuantity()
					+" where invoice_number="+transactionDTO.getInvoice_number());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteTransaction(int invoice_number) {
		// TODO Auto-generated method stub
		try {
			
			st.execute("delete from transaction where invoice_number="+invoice_number);
			System.out.println("deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public TransactionDTO getTransaction(int invoice_no) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs=st.executeQuery("select * from transaction where invoice_number="+invoice_no);
			while(rs.next()) {
				return createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Set<TransactionDTO> getAllTransaction() {
		// TODO Auto-generated method stub
		Set<TransactionDTO> set =  new HashSet<TransactionDTO>() ;
		
		try {
			ResultSet rs=st.executeQuery("select * from transaction");
			while(rs.next()) {
				set.add( createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}

	@Override
	public Set<TransactionDTO> getMyTransaction(int invoice_no) {
		// TODO Auto-generated method stub
		Set<TransactionDTO> set =  new HashSet<TransactionDTO>() ;
		
		try {
			ResultSet rs=st.executeQuery("select * from transaction where invoice_number="+invoice_no);
			while(rs.next()) {
				set.add( createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
			System.out.println("transaction done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
}
