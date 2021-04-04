package consignment_tracker;

import java.time.DayOfWeek;
import java.time.LocalDateTime;



public class Estimator implements Tracker{
	
	
	private LocalDateTime start;
	private float distance;
	private float speed;
	private BreakInterval interval;
	
	
	public Estimator(LocalDateTime start,float distance,float speed,BreakInterval interval) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.distance = distance;
		this.speed = speed;
		this.interval = interval;
	}
	

	public LocalDateTime getDeliveryDateAndTime() {
		
		LocalDateTime arrival = LocalDateTime.of(2021,3,21,0,0,0);
		LocalDateTime i = null;
		System.out.println(arrival.getDayOfWeek());
		
		if(arrival.getDayOfWeek() == DayOfWeek.SATURDAY) 
		{
			System.out.println("sat");
			arrival = arrival.plusDays(2);
			arrival = LocalDateTime.of(arrival.getYear(),arrival.getMonth(),arrival.getDayOfMonth(),0,0,0);
			i = arrival;
		}
		else if(arrival.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			arrival = arrival.plusDays(1);
			arrival = LocalDateTime.of(arrival.getYear(),arrival.getMonth(),arrival.getDayOfMonth(),0,0,0);
			i = arrival;
		}
		
		double hours = Math.floor(distance/speed);
		double minutes = ((distance%speed)/speed*60);
		double seconds = Math.floor((minutes - (int)minutes)*60);
		int min = (int)minutes;
		int hr = (int)hours;
		int sec = (int)seconds;
				
		System.out.println(hr);
		System.out.println(min);
		System.out.println(sec);
		
		System.out.println(arrival);
		arrival = arrival.plusSeconds(hr*3600+min*60+sec);
		System.out.println(arrival);
		
		
		arrival = arrival.plusSeconds(interval.hours*3600+interval.minutes*60+interval.seconds);
		System.out.println(arrival);
		System.out.println(i);
		
		int count = 0;
		while(!i.toLocalDate().isEqual(arrival.toLocalDate())) {
			//System.out.println(ii);
			
			if(i.getDayOfWeek() == DayOfWeek.SATURDAY || i.getDayOfWeek() == DayOfWeek.SUNDAY
					|| (i.getDayOfMonth() == 26 && i.getMonth().getValue() == 1)
					||(i.getDayOfMonth() == 15 && i.getMonth().getValue() == 8)
					||(i.getDayOfMonth() == 2 && i.getMonth().getValue() == 10)) {
				count++;
			}
				
				
			System.out.println(i.getDayOfWeek());
			i = i.plusDays(1);
		}
		System.out.println(count);
		arrival = arrival.plusDays(count);
		System.out.println(arrival);
		
		if(arrival.getDayOfWeek() == DayOfWeek.SATURDAY) 
		{
			System.out.println("sat");
			arrival = arrival.plusDays(2);
			arrival = LocalDateTime.of(arrival.getYear(),arrival.getMonth(),arrival.getDayOfMonth(),9,0,0);
			i = arrival;
		}
		else if(arrival.getDayOfWeek() == DayOfWeek.SUNDAY)
		{
			System.out.println("sun");
			arrival = arrival.plusDays(1);
			arrival = LocalDateTime.of(arrival.getYear(),arrival.getMonth(),arrival.getDayOfMonth(),9,0,0);
			i = arrival;
		}
		
		System.out.println("ETA : "+arrival);
		return arrival;
	}
}



