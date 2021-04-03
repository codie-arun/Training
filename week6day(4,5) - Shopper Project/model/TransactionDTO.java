package model;

import java.io.Serializable;

public class TransactionDTO implements Serializable{

	int invoice_number;
	int item_no;
	int quantity;
	
	public final int getInvoice_number() {
		return invoice_number;
	}
	public final void setInvoice_number(int invoice_number) {
		this.invoice_number = invoice_number;
	}
	public final int getItem_no() {
		return item_no;
	}
	public final void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public final int getQuantity() {
		return quantity;
	}
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "TransactionDTO [invoice_number=" + invoice_number + ", item_no=" + item_no + ", quantity=" + quantity
				+ "]";
	}
	
	
	
	
}
