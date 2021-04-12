package myspring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class FactoryClient {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ShoeSeller shop = ctx.getBean("advisedShop",ShoeSeller.class);
		
		Customer customer = new ShoeCustomer("ramu");
		Shoe shoe = shop.sellShoe(customer);
		shop.packshoe();
		System.out.println(shoe);
		
		
		Export export = (Export)shop;
		export.doExport();
		

//		GokulShoeShop seller2=shop.getClone();
//		System.out.println(seller2.getName());
//		System.out.println(seller2.getMylist());
//		
//		System.out.println(shop.getFactory().getKey());
//		System.out.println(shop.getKey());
		
		ctx.close();
	}

}
