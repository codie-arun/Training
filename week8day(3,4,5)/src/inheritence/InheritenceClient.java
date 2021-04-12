package inheritence;

import org.hibernate.Session;

import utility.HibernateUtility;

public class InheritenceClient {

	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		ShoeFactory factory=new ShoeFactory();
		factory.setName("parent shoefactory....");
		
		BataShoeFactory bsf=new BataShoeFactory();
		bsf.setName("parent name bata ");
		bsf.setBataname("bata");
		
		LakhaniShoeFactory lsf=new LakhaniShoeFactory();
		lsf.setName("parent name lakhani");
		lsf.setLakhaniname("lakhani");
		
		session.save(factory);
		session.save(bsf);
		session.save(lsf);
		
		session.beginTransaction().commit();
	}

}
