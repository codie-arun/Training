package myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {

	public static void main(String[] args) {
		
		BookDTO book = new BookDTO(1,"Java","James",340);
		
		Comment comment =  new Comment();
		comment.setMsg("Hii am a Comment");
		
		book.setComment(comment);
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.save(book);
		
		session.beginTransaction().commit();
	}
	
}
