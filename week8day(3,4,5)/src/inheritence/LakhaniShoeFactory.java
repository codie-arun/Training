package inheritence;

public class LakhaniShoeFactory extends ShoeFactory{

	private String lakhaniname;

	public final String getLakhaniname() {
		return lakhaniname;
	}

	public final void setLakhaniname(String lakhaniname) {
		this.lakhaniname = lakhaniname;
	}

	public void visit() {
		new Handler().handle(this);
	}
	
	
}
