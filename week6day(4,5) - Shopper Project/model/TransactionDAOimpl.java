package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TransactionDAOimpl implements TransactionDAO,Cloneable{
	
	private static TransactionDAOimpl transdao;
	private Properties prop;
	private TransactionDAOimpl(Properties prop) {
		this.prop = prop;
	}
	
	
	synchronized public static TransactionDAOimpl getTransactionDAOimpl(Properties prop) {
		
		if(transdao==null) {
			transdao=new TransactionDAOimpl(prop);
			return transdao;
		}
		else {
			return transdao.createClone();
		}
		
	}
	
	
	public TransactionDAOimpl createClone() {
		try {
			transdao = (TransactionDAOimpl)super.clone();
			return transdao;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insertTransaction(TransactionDTO transactionDTO) {
		
		
		try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("insert into transaction values (?,?,?)");
			ps.setInt(1, transactionDTO.getInvoice_number());
			ps.setInt(2, transactionDTO.getItem_no());
			ps.setInt(3, transactionDTO.getQuantity());
			
			
			int count=ps.executeUpdate();
			con.commit();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}

	}

	@Override
	public int updateTransaction(TransactionDTO transactionDTO) {
		// TODO Auto-generated method stub
		
//		try {
//			st.executeUpdate("update transaction set "
//					+"item_no ="+transactionDTO.getItem_no()
//					+",quantity ="+transactionDTO.getQuantity()
//					+" where invoice_number="+transactionDTO.getInvoice_number());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		return 0;
	}

	@Override
	public int deleteTransaction(int invoice_number) {
		// TODO Auto-generated method stub
//		try {
//			
//			st.execute("delete from transaction where invoice_number="+invoice_number);
//			System.out.println("deleted");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return 0;
	}

	@Override
	public TransactionDTO getTransaction(int invoice_no) {
		// TODO Auto-generated method stub
//		try {
//			ResultSet rs=st.executeQuery("select * from transaction where invoice_number="+invoice_no);
//			while(rs.next()) {
//				return createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3));
//			}
//			System.out.println("done");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return null;
		
	}

	@Override
	public Set<TransactionDTO> getAllTransaction() {
		// TODO Auto-generated method stub
//		Set<TransactionDTO> set =  new HashSet<TransactionDTO>() ;
//		
//		try {
//			ResultSet rs=st.executeQuery("select * from transaction");
//			while(rs.next()) {
//				set.add( createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
//			}
//			System.out.println("done");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return set;
		return null;
	}

	@Override
	public Set<TransactionDTO> getMyTransaction(int invoice_no) {
		// TODO Auto-generated method stub
//		Set<TransactionDTO> set =  new HashSet<TransactionDTO>() ;
//		
//		try {
//			ResultSet rs=st.executeQuery("select * from transaction where invoice_number="+invoice_no);
//			while(rs.next()) {
//				set.add( createTransactionDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
//			}
//			System.out.println("transaction done");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return set;
		return null;
	}
	
}
