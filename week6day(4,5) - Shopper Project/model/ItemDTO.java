package model;

public class ItemDTO {

	int item_no;
	String item_name;
	int item_unit;
	int item_price;
	String item_category;
	
	
	
	
	
	public final int getItem_no() {
		return item_no;
	}
	public final void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public final String getItem_name() {
		return item_name;
	}
	public final void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public final int getItem_unit() {
		return item_unit;
	}
	public final void setItem_unit(int item_unit) {
		this.item_unit = item_unit;
	}
	public final int getItem_price() {
		return item_price;
	}
	public final void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public final String getItem_category() {
		return item_category;
	}
	public final void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	@Override
	public String toString() {
		return "ItemDTO [item_no=" + item_no + ", item_name=" + item_name + ", item_unit=" + item_unit + ", item_price="
				+ item_price + ", item_category=" + item_category + "]";
	}
	
	

}
