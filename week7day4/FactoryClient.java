package myspring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ShoeSeller seller = ctx.getBean("shop",ShoeSeller.class);
		
		Customer customer = new ShoeCustomer("ramu");
		Shoe shoe = seller.sellShoe(customer);
		System.out.println(shoe);
		
	}

}
