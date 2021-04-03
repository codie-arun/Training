package model;

import java.io.Serializable;

public class CustomerDTO implements Cloneable,Serializable{

	private int customer_no;
	private String customer_name;
	private String customer_address;
	private String customer_email;
	private int customer_phone;
	private String customer_pass;
	private int customer_flag;
	
	private static CustomerDTO customer;
	
	private CustomerDTO() {
		
	}
	
		
	public CustomerDTO(int customer_no, String customer_name, String customer_address, String customer_email,
			int customer_phone, String customer_pass,int customer_flag) {
		
		this.customer_no = customer_no;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_phone = customer_phone;
		this.customer_pass = customer_pass;
		this.customer_flag = customer_flag;
	}



	public static synchronized CustomerDTO getCustomerDTO() {
		if(customer == null) {
			customer = new CustomerDTO();
			return customer;
		}else {
			return customer.getClone();
		}
	}
	
	
	public CustomerDTO getClone() {
		try {
			return (CustomerDTO)super.clone();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public final int getCustomer_no() {
		return customer_no;
	}
	public final void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public final String getCustomer_name() {
		return customer_name;
	}
	public final void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public final String getCustomer_address() {
		return customer_address;
	}
	public final void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public final String getCustomer_email() {
		return customer_email;
	}
	public final void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public final int getCustomer_phone() {
		return customer_phone;
	}
	public final void setCustomer_phone(int customer_phone) {
		this.customer_phone = customer_phone;
	}
	public final String getCustomer_pass() {
		return customer_pass;
	}
	public final void setCustomer_pass(String customer_pass) {
		this.customer_pass = customer_pass;
	}
	public final int getCustomer_flag() {
		return customer_flag;
	}
	public final void setCustomer_flag(int customer_flag) {
		this.customer_flag = customer_flag;
	}


	@Override
	public String toString() {
		return "CustomerDTO [customer_no=" + customer_no + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_email=" + customer_email + ", customer_phone=" + customer_phone
				+ ", customer_pass=" + customer_pass + ", customer_flag=" + customer_flag + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_address == null) ? 0 : customer_address.hashCode());
		result = prime * result + ((customer_email == null) ? 0 : customer_email.hashCode());
		result = prime * result + customer_flag;
		result = prime * result + ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result + customer_no;
		result = prime * result + ((customer_pass == null) ? 0 : customer_pass.hashCode());
		result = prime * result + customer_phone;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (customer_address == null) {
			if (other.customer_address != null)
				return false;
		} else if (!customer_address.equals(other.customer_address))
			return false;
		if (customer_email == null) {
			if (other.customer_email != null)
				return false;
		} else if (!customer_email.equals(other.customer_email))
			return false;
		if (customer_flag != other.customer_flag)
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		if (customer_no != other.customer_no)
			return false;
		if (customer_pass == null) {
			if (other.customer_pass != null)
				return false;
		} else if (!customer_pass.equals(other.customer_pass))
			return false;
		if (customer_phone != other.customer_phone)
			return false;
		return true;
	}


	
	
	
	
	
}
