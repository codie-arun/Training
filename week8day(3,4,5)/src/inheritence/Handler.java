package inheritence;

public class Handler {

	public void handle(ShoeFactory factory) {
		System.out.println(factory.getName());
	}
	public void handle(BataShoeFactory bsf) {
		System.out.println(bsf.getBataname());
	}
	public void handle(LakhaniShoeFactory lsf) {
		System.out.println(lsf.getLakhaniname());
	}
	
}
