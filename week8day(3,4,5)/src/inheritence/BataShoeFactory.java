package inheritence;

public class BataShoeFactory extends ShoeFactory{

	private String bataname;

	public final String getBataname() {
		return bataname;
	}

	public final void setBataname(String bataname) {
		this.bataname = bataname;
	}
	
	public void visit() {
		new Handler().handle(this);
	}

}
