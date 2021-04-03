package model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Set;

public class CustomerDAOImpl implements CustomerDAO,Cloneable{

	private static CustomerDAOImpl cusdao;
	private Properties prop;
	private CustomerDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static CustomerDAOImpl getCustomerDAOImpl(Properties prop) {
		
		if(cusdao==null) {
			cusdao=new CustomerDAOImpl(prop);
			return cusdao;
		}
		else {
			return cusdao.createClone();
		}
		
	}
	
	
	public CustomerDAOImpl createClone() {
		try {
			cusdao = (CustomerDAOImpl)super.clone();
			return cusdao;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	@Override
	public int insertCustomer(CustomerDTO customerDTO) {

		try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("insert into customer values (?,?,?,?,?,?,?)");
			ps.setInt(1, customerDTO.getCustomer_no());
			ps.setString(2, customerDTO.getCustomer_name());
			ps.setString(3, customerDTO.getCustomer_address());
			ps.setString(4, customerDTO.getCustomer_email());
			ps.setInt(5, customerDTO.getCustomer_phone());
			ps.setString(6, customerDTO.getCustomer_pass());
			ps.setInt(7, customerDTO.getCustomer_flag());
			
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
	public int updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(int cust_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomerDTO getCustomer(int cust_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CustomerDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getCustomerByName(String uname) {
		
		try {
		CustomerDTO custDTO = CustomerDTO.getCustomerDTO();
		Connection con=DBUtility.getConnection(prop);
		PreparedStatement ps=con.prepareStatement("select * from customer where customer_name=?");
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			custDTO.setCustomer_no(rs.getInt(1));
			custDTO.setCustomer_name(rs.getString(2));
			custDTO.setCustomer_address(rs.getString(3));
			custDTO.setCustomer_email(rs.getString(4));
			custDTO.setCustomer_phone(rs.getInt(5));
			custDTO.setCustomer_pass(rs.getString(6));
			custDTO.setCustomer_flag(rs.getInt(7));
		}
		System.out.println(custDTO);
		DBUtility.closeConnection(null);
		return custDTO;
	}catch(Exception e) {
		e.printStackTrace();
		DBUtility.closeConnection(e);
		return null;
	}
	}

	@Override
	public int setCustomerFlag(CustomerDTO customerDTO, int flag) {
try {
			
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement ps=con.prepareStatement("update customer set customer_flag = ? where customer_name = ?");
			ps.setInt(1, flag);
			ps.setString(2, customerDTO.getCustomer_name());			
			int count=ps.executeUpdate();
			con.commit();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	
	
	
	
	
}
