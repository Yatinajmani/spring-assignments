package service;

import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class AuthorService {

    final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    final Scanner scanner = new Scanner(System.in);

    public Author getAuthorByid(int id) {
        return session.get(Author.class, id);
    }

    public List<Author> getAuthors() {
        session = sessionFactory.openSession();
        return (List<Author>) session.createQuery("from Author").list();
    }

    public void addAuthor() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(getInput());
        session.getTransaction().commit();
    }

    private Author getInput() {
        Author author = new Author();
        System.out.println("Enter First name :");
        author.setFirstName(scanner.nextLine());
        System.out.println("Enter Last name :");
        author.setLastName(scanner.nextLine());
        System.out.println("Enter 3 Subjects :");
        Set<String> subjects = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            subjects.add(scanner.nextLine());
        }
        author.setSubjects(subjects);
        System.out.println("Enter Age :");
        try {
            author.setAge(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Enter valid age.");
        }
        return author;
    }

    public void deleteAuthor(int id) {
        if (getAuthorByid(id) != null) {
            session.beginTransaction();
            session.delete(getAuthorByid(id));
            session.getTransaction().commit();
            System.out.println("User deleted.");
        } else
            System.out.println("No user found.");
    }

    public void updateAuthor(int id) {
        if (getAuthorByid(id) != null) {
            Author author = getInput();
            author.setId(getAuthorByid(id).getId());
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update("Author", author);
            session.getTransaction().commit();
            System.out.println("User updated.");
        } else
            System.out.println("No user found.");
    }

    public void destroy() {
        scanner.close();
        session.close();
        sessionFactory.close();
    }

    public void dummyRecords() {
        System.out.println("Entering Books Records.");
        session = sessionFactory.openSession();
        List books = session.createQuery("from Book").list();

        for (int i = 1; i <= 4; i++) {
            //  //    Exercise 15
//            Author author = new Author("Author" + i, "Lname" + i, 20 + i, new Date()
//                    , session.get(Book.class, i));

            //    Exercise 17
            Author author = new Author("Author" + i, "Lname" + i, 20 + i, new Date()
                    , books);
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }


//      Exercise 16.1,16.2
//        Author author = new Author("Author" + 1, "Lname" + 1, 21, new Date()
//                , books.subList(0, 2));
//        Author author1 = new Author("Author" + 2, "Lname" + 2, 22, new Date()
//                , books.subList(2, 4));
//        session.beginTransaction();
//        session.save(author);
//        session.save(author1);
//        for (int i = 0; i < 4; i++) {
//            Book book = (Book) books.get(i);
//            if (i < 2) {
//                book.setAuthors(Arrays.asList(author));
//            } else
//                book.setAuthors(Arrays.asList(author1));
//        }
//        books.forEach(book -> session.save(book));
//        session.getTransaction().commit();

    }
}
