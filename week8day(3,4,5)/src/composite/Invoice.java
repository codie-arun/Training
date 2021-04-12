package composite;

import javax.persistence.EmbeddedId;

public class Invoice {
	//@EmbeddedId
	private CompKey compkey;
	private String details;
	public CompKey getCompkey() {
		return compkey;
	}
	public void setCompkey(CompKey compkey) {
		this.compkey = compkey;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}