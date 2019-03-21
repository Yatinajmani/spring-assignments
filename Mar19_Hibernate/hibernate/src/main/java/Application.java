import service.AuthorService;
import service.BookService;

import java.util.Scanner;

public class Application {

    final static AuthorService authorService = new AuthorService();
    final static BookService bookService = new BookService();

    public static void main(String[] args) {
        bookService.dummyRecords();
        authorService.dummyRecords();
        int choice;
        do {
            System.out.println("1.Add Author");
            System.out.println("2.View Authors");
            System.out.println("3.View an Author by id");
            System.out.println("4.View an Book by id");
            System.out.println("5.Update Author");
            System.out.println("6.Delete Author");
            System.out.println("7.Exit");
            System.out.print("Enter Choice :");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    authorService.addAuthor();
                    break;
                case 2:
                    System.out.println(authorService.getAuthors());
                    break;
                case 3:
                    System.out.println("Enter Id of author to get author :");
                    System.out.println(authorService.getAuthorByid(scanner.nextInt()));
                    break;
                case 4:
                    System.out.println("Enter Id of book to get book :");
                    System.out.println(bookService.getBookById(scanner.nextInt()));
                    break;
                case 5:
                    System.out.println("Enter Id of author to update author :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    authorService.updateAuthor(id);
                    break;
                case 6:
                    System.out.println("Enter Id of author to delete author :");
                    authorService.deleteAuthor(scanner.nextInt());
                    break;
                case 7:
                    System.out.println("Bye..");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } while (choice > 0 && choice < 7);
        authorService.destroy();
        bookService.destroy();
        System.exit(0);
    }
}
