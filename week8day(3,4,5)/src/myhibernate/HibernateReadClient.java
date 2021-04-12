package myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateReadClient {

	public static void main(String[] args) {
	
		BookDTO book = new BookDTO(1,"Java","James",340);
		
		Comment comment =  new Comment();
		comment.setMsg("Hii am a Comment");
		
		book.setComment(comment);
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		BookDTO bookObj=(BookDTO)session.get(BookDTO.class, Integer.valueOf(1));
		
	    System.out.println(bookObj);
		
		Comment comm=bookObj.getComment();
		
		System.out.println(comm.getMsg());
	}
		
}
