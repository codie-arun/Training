package model;

import java.io.Serializable;
import java.time.LocalDate;

public class InvoiceDTO implements Serializable{

	int invoice_no;
	int customer_no;
	LocalDate invoice_date;
	
	
	public final int getInvoice_no() {
		return invoice_no;
	}
	public final void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}
	public final int getCustomer_no() {
		return customer_no;
	}
	public final void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public final LocalDate getInvoice_date() {
		return invoice_date;
	}
	public final void setInvoice_date(LocalDate invoice_date) {
		this.invoice_date = invoice_date;
	}
	
	
	
	@Override
	public String toString() {
		return "InvoiceDTO [invoice_no=" + invoice_no + ", customer_no=" + customer_no + ", invoice_date="
				+ invoice_date + "]";
	}
	
	
	
	
}
