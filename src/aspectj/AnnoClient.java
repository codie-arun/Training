package aspectj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoClient {
	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("aspconfig.xml");
		
		CustomerBo customer =(CustomerBo) ctx.getBean("customerBo");        
		//customer.addCustomer();
		//customer.addCustomerReturnValue();
		//customer.addCustomerThrowException();
		customer.addCustomerAround("arun");
		ctx.close();
	}
}
