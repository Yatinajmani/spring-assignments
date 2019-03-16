package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import repository.UserRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use datasource with DriverManagerDataSource, dbcp2.BasicDataSource and
 * SingleConnectionDataSource to print the records of user tables
 */
@Component
public class Application {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    Logger logger;

    public static void main(String[] args) throws Exception {
        //Exercise3
        ApplicationContext context = new ClassPathXmlApplicationContext("datasources-config.xml");
        Application application = context.getBean("application", Application.class);
        application.userService.printUsers();
        application.logger.info("======================Printing Users Using DriverManagerDataSource" +
                "======================");
        application.userService.singlePrintUsers();
        application.logger.info("======================Printing Users Using SingleConnectionDataSource" +
                "======================");
        application.userService.basicDataSourcePrintUsers();
        application.logger.info("======================Printing Users Using BasicDataSource" +
                "======================");

        //Exercise4
        System.out.println("No. of Users : " + application.userService.userCount());

        Scanner scanner = new Scanner(System.in);
        //Exercise5
        System.out.println("Enter username : ");
        String str = scanner.nextLine();
        System.out.println(application.userService.getName(str));

        //Exercise6
        User user = new User();
        System.out.println("Enter username : ");
        user.setUsername(scanner.nextLine());
        System.out.println("Enter password : ");
        user.setPassword(scanner.nextLine());
        System.out.println("Enter name : ");
        user.setName(scanner.nextLine());
        System.out.println("Enter Date Of Birth(dd/MM/yyyy) : ");
        try {
            user.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
        } catch (ParseException e) {
            application.logger.log(Level.SEVERE, "Incorrect Format.");
        }
        System.out.println("Enter age : ");
        try {
            user.setAge(scanner.nextInt());
            application.userService.insertUser(user);
        } catch (InputMismatchException e) {
            application.logger.log(Level.SEVERE, "Incorrect Input.Try Again.");
        }
        scanner.nextLine();

        //Exercise7
        System.out.println("Enter name : ");
        application.userService.getUserMap(scanner.nextLine());

        //Exercise8
        System.out.println("Enter name for getting users list : ");
        application.userService.getUsersList(scanner.nextLine());

        //Exercise9
        System.out.println("Enter name to get User object : ");
        System.out.println(application.userService.getUser(scanner.nextLine()));


        //Exercise10
        System.out.print("No. of Users : ");
        application.userService.getUserCountByHibernate();

        //Exercise11
        System.out.print("Adding 2 user : ");
        application.userRepo.insert();

        //Exercise12
        System.out.print("Demonstrating read-only," +
                "timeout," +
                "rollback-for," +
                "no-rollback-for.");
        application.userRepo.insert2();
        application.userRepo.insert3();
        application.userRepo.insert4();
        application.userRepo.insert5();
    }
}