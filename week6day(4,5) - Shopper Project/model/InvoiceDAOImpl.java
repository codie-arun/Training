package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class InvoiceDAOImpl implements InvoiceDAO,Cloneable{

	
	private static InvoiceDAOImpl invdao;
	private Properties prop;
	private InvoiceDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static InvoiceDAOImpl getInvoiceDAOImpl(Properties prop) {
		
		if(invdao==null) {
			invdao=new InvoiceDAOImpl(prop);
			return invdao;
		}
		else {
			return invdao.createClone();
		}
		
	}
	
	
	public InvoiceDAOImpl createClone() {
		try {
			invdao = (InvoiceDAOImpl)super.clone();
			return invdao;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public int insertInvoice(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
		
try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("insert into invoice values (?,?,?)");
			ps.setInt(1, invoiceDTO.getInvoice_no());
			ps.setDate(2, Date.valueOf(invoiceDTO.getInvoice_date()));
			ps.setInt(3, invoiceDTO.getCustomer_no());
			
			
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
	public int updateInvoice(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
		
//		try {
//			st.executeUpdate("update invoice set "
//					+"customer_no ="+invoiceDTO.getCustomer_no()
//					+" where invoice_no="+invoiceDTO.getInvoice_no());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		return 0;
	}

	@Override
	public int deleteInvoice(int invno) {
		// TODO Auto-generated method stub
//		try {
//			
//			st.execute("delete from invoice where invoice_no="+invno);
//			System.out.println("deleted");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return 0;
	}

	@Override
	public InvoiceDTO getInvoice(int invno) {
		// TODO Auto-generated method stub
//		try {
//			ResultSet rs=st.executeQuery("select * from invoice where invoice_no="+invno);
//			while(rs.next()) {
//				return createInvoiceDTO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getInt(3));
//			}
//			System.out.println("done");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		return null;
	}

	@Override
	public Set<InvoiceDTO> getAllInvoice() {
		// TODO Auto-generated method stub
		
//		Set<InvoiceDTO> set =  new HashSet<InvoiceDTO>() ;
//		
//		try {
//			ResultSet rs=st.executeQuery("select * from invoice");
//			while(rs.next()) {
//				set.add(createInvoiceDTO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getInt(3)));
//			}
//			System.out.println("done");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return set;
		return null;
	}

	

}
