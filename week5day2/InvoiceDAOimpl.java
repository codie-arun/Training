package week5day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InvoiceDAOimpl implements InvoiceDAO{

	
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	
	
	public InvoiceDAOimpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost/purchase","root","arun");
		this.st = st = con.createStatement();
	}
	
	public InvoiceDTO createInvoiceDTO(int invoice_no,LocalDate invoice_date,int customer_no) {
		InvoiceDTO myInvoiceDTO = new InvoiceDTO();
		myInvoiceDTO.setInvoice_no(invoice_no);
		myInvoiceDTO.setCustomer_no(customer_no);
		myInvoiceDTO.setInvoice_date(invoice_date);
		
		return myInvoiceDTO;
	}
	
	
	@Override
	public int insertInvoice(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
		
		String s = invoiceDTO.getInvoice_date().toString();
		
		try {
			
//			System.out.println(customerDTO.getCustomer_no());
//			System.out.println(customerDTO.getCustomer_name());
//			System.out.println(customerDTO.getCustomer_address());
//			System.out.println(customerDTO.getCustomer_email());
//			System.out.println(customerDTO.getCustomer_phone());
			
			String sql = "insert into customer values("+invoiceDTO.getInvoice_no() +",STR_TO_DATE('"+s+"', '%Y-%m-%d')" +","+invoiceDTO.getCustomer_no() +")";
			System.out.println(sql);
			st.execute("insert into invoice values("+invoiceDTO.getInvoice_no()
					+",STR_TO_DATE('"+s+"', '%Y-%m-%d')"
					+","+invoiceDTO.getCustomer_no()
					+")");
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateInvoice(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
		
		try {
			st.executeUpdate("update invoice set "
					+"customer_no ="+invoiceDTO.getCustomer_no()
					+" where invoice_no="+invoiceDTO.getInvoice_no());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteInvoice(int invno) {
		// TODO Auto-generated method stub
		try {
			
			st.execute("delete from invoice where invoice_no="+invno);
			System.out.println("deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public InvoiceDTO getInvoice(int invno) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs=st.executeQuery("select * from invoice where invoice_no="+invno);
			while(rs.next()) {
				return createInvoiceDTO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getInt(3));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<InvoiceDTO> getAllInvoice() {
		// TODO Auto-generated method stub
		
		Set<InvoiceDTO> set =  new HashSet<InvoiceDTO>() ;
		
		try {
			ResultSet rs=st.executeQuery("select * from invoice");
			while(rs.next()) {
				set.add(createInvoiceDTO(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getInt(3)));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return set;
		
	}

	

}
