package repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class User1Repo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SessionFactory sessionFactoryBean;

    @Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    //@Transactional(propagation = Propagation.NESTED)
    //@Transactional(propagation = Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.SUPPORTS)
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void insert() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, "Karan", "Karanas12", "Karan", 23, new Date());
    }
}
