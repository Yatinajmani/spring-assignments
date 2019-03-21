package service;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class BookService {
    final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    final Scanner scanner = new Scanner(System.in);

    public void dummyRecords() {
        System.out.println("Entering 4 Books.");
        session = sessionFactory.openSession();
        for (int i = 1; i <= 4; i++) {
            Book book = new Book("Book" + i);
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }
    }

    public Book getBookById(int id) {
        session = sessionFactory.openSession();
        return session.get(Book.class, id);
    }

    public void destroy() {
        scanner.close();
        session.close();
        sessionFactory.close();
    }

}
