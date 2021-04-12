package annospring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FactoryClient {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		//new FileSystemXmlApplicationContext();
		
		GokulShoeShop seller=ctx.getBean("gokulShoeShop",GokulShoeShop.class);
		
		Customer customer=new ShoeCustomer("ramu");
		
		
		Shoe shoe=seller.sellShoe(customer);
		
		System.out.println(shoe);
		
//		ctx.getBean("shop",ShoeSeller.class);
//		ctx.getBean("shop",ShoeSeller.class);
		
//		GokulShoeShop seller2=seller.getClone();
//		
//		System.out.println(seller2.getName());
//		System.out.println(seller2.getMylist());
		ctx.close();
	}
}
