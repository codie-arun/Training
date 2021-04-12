package composite;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CompkeyClient {
	public static void main(String[] args) {
		SessionFactory factory = 
				new AnnotationConfiguration().configure("hibernate.anno.cfg.xml").buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
		Invoice inv=new Invoice();
		CompKey ck=new CompKey();
		ck.setInv_id(101);
		ck.setItem_id(2);
		inv.setCompkey(ck);
		
		inv.setDetails("You save 100 rs on this purchase");
		
		session.save(inv);
		session.beginTransaction().commit();
	}
}