package week5day2;

import java.util.Set;

public interface CustomerDAO {

	public int insertCustomer(CustomerDTO customerDTO);
	public int updateCustomer(CustomerDTO customerDTO);
	public int deleteCustomer(int cust_no);
	public CustomerDTO getCustomer(int cust_no);
	public Set<CustomerDTO> getAllCustomer();

}
