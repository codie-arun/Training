package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CustomerDAOimpl implements CustomerDAO{

	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	
	
	public CustomerDAOimpl() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection("jdbc:mysql://localhost/purchase","root","arun");
		this.st = st = con.createStatement();
	}
	
	public CustomerDTO createCustomerDTO(int customer_no,String customer_name,String customer_address,String customer_email,int customer_phone) {
		CustomerDTO mycustomerDTO = new CustomerDTO();
		mycustomerDTO.setCustomer_name(customer_name);
		mycustomerDTO.setCustomer_no(customer_no);
		mycustomerDTO.setCustomer_address(customer_address);
		mycustomerDTO.setCustomer_email(customer_email);
		mycustomerDTO.setCustomer_phone(customer_phone);
		return mycustomerDTO;
	}
	
	@Override
	public int insertCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		try {
			
//			System.out.println(customerDTO.getCustomer_no());
//			System.out.println(customerDTO.getCustomer_name());
//			System.out.println(customerDTO.getCustomer_address());
//			System.out.println(customerDTO.getCustomer_email());
//			System.out.println(customerDTO.getCustomer_phone());
			
			st.execute("insert into customer values("+customerDTO.getCustomer_no()
					+",'"+customerDTO.getCustomer_name()
					+"','"+customerDTO.getCustomer_address()
					+"','"+customerDTO.getCustomer_email()
					+"',"+customerDTO.getCustomer_phone()
					+")");
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		try {
			st.executeUpdate("update customer set "
					+"customer_name ='"+customerDTO.getCustomer_name()
					+"',customer_address ='"+customerDTO.getCustomer_address()
					+"',customer_email ='"+customerDTO.getCustomer_email()
					+"',customer_phone ="+customerDTO.getCustomer_phone()
					+" where customer_no="+customerDTO.getCustomer_no());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteCustomer(int cust_no) {
		// TODO Auto-generated method stub
		
		try {
			
			st.execute("delete from customer where customer_no="+cust_no);
			System.out.println("deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public CustomerDTO getCustomer(int cust_no) {
		// TODO Auto-generated method stub
		
		try {
			ResultSet rs=st.executeQuery("select * from customer where customer_no="+cust_no);
			while(rs.next()) {
				return createCustomerDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<CustomerDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		
		Set<CustomerDTO> set =  new HashSet<CustomerDTO>() ;
		
		try {
			ResultSet rs=st.executeQuery("select * from customer");
			while(rs.next()) {
				set.add( createCustomerDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}

	

}
