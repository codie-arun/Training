package consignment_tracker;

import java.time.LocalDateTime;

public class Demo {
	
	public static void main(String[] args) {
		
		
		
		
		Tracker e = new Estimator(LocalDateTime.now(),35000,100,new BreakInterval(48, 0, 0));
		System.out.println(e.getDeliveryDateAndTime());
		
		
		
	}
	
}
