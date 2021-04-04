package database;

import java.io.Serializable;

public class CustomerDTO implements Serializable{

	int customer_no;
	String customer_name;
	String customer_address;
	String customer_email;
	int customer_phone;
	
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

	
	@Override
	public String toString() {
		return "CustomerDTO [customer_no=" + customer_no + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_email=" + customer_email + ", customer_phone=" + customer_phone + "]";
	}





		
	
}
