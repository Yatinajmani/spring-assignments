package service;

import entity.User;
import entity.UserMapper;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {

    private DataSource dataSource;

    private DataSource singleDataSource;

    private DataSource basicDataSource;

    private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactoryBean;

    @Autowired
    public UserService(@Qualifier("singleDataSource") DataSource singleDataSource,
                       @Qualifier("dbcp2BasicDataSource") DataSource basicDataSource,
                       DataSource dataSource,
                       JdbcTemplate jdbcTemplate,
                       SessionFactory sessionFactoryBean) {
        this.singleDataSource = singleDataSource;
        this.basicDataSource = basicDataSource;
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.sessionFactoryBean = sessionFactoryBean;
    }

    void printUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.printf("%-15s" + "Age", "Name");
        System.out.println();
        while (resultSet.next()) {
            System.out.printf("%-15s" + resultSet.getString("age"),
                    resultSet.getString("name"));
            System.out.println();
        }
    }

    void singlePrintUsers() throws SQLException {
        dataSource = singleDataSource;
        printUsers();
    }

    void basicDataSourcePrintUsers() throws SQLException {
        dataSource = basicDataSource;
        printUsers();
    }

    int userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    String getName(String username) {
        String sql = "SELECT name FROM user where username=?";
        try {
            return "Name : " + jdbcTemplate.queryForObject(sql, String.class, username);
        } catch (DataAccessException e) {
//            e.printStackTrace();
        }
        return "Username " + username + " not found.";
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        System.out.println("No. of rows Affected : " + jdbcTemplate
                .update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getDob()));
    }

    void getUserMap(String name) {
        String sql = "SELECT * FROM user WHERE name = ? ";
        try {
            System.out.println(jdbcTemplate.queryForMap(sql, name));
        } catch (DataAccessException e) {
            if (e instanceof IncorrectResultSizeDataAccessException) {
                System.out.println("Multiple Users have same name.Therefore returning list.");
                System.out.println(jdbcTemplate.queryForList(sql, name));
            } else
                System.out.println("User with name " + name + " not found.");
        }
    }

    void getUsersList(String name) {
        String sql = "SELECT * FROM user WHERE name like ? ";
        try {
            System.out.println(jdbcTemplate.queryForList(sql, "%" + name + "%"));
        } catch (DataAccessException e) {
            System.out.println("User with name " + name + " not found.");
        }
    }

    Optional<User> getUser(String name) {
        String sql = "SELECT * FROM user WHERE name = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new String[]{name}, new UserMapper()));
        } catch (DataAccessException e) {
            if (e instanceof IncorrectResultSizeDataAccessException)
                System.out.println("Multiple Users have same name.");
        }
        return Optional.empty();
    }

    void getUserCountByHibernate() {
        String sql = "SELECT COUNT(*) FROM User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }
}
