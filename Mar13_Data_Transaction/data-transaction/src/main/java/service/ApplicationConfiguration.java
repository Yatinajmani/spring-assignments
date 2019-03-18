package service;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
public class ApplicationConfiguration {
    private final String url = "jdbc:mysql://localhost:3306/springDemo";
    private final String driverClassName = "com.mysql.jdbc.Driver";
    private final String username = "root";
    private final String password = "";

    @Scope("singleton")
    @Bean("dataSource")
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    @Scope("singleton")
    @Bean("singleDataSource")
    DataSource singleDataSource() {
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();
        singleConnectionDataSource.setDriverClassName(driverClassName);
        singleConnectionDataSource.setUrl(url);
        singleConnectionDataSource.setUsername(username);
        singleConnectionDataSource.setPassword(password);
        singleConnectionDataSource.setSuppressClose(true);
        return singleConnectionDataSource;
    }

    @Bean("dbcp2BasicDataSource")
    DataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setInitialSize(3);
        basicDataSource.setMaxTotal(6);
        return basicDataSource;
    }

    @Scope("singleton")
    @Bean
    Logger logger() {
        return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties((Properties) new Properties()
                .setProperty("dialect", "org.hibernate.dialect.MySQLDialect"));
        localSessionFactoryBean.setPackagesToScan("entity");
        return localSessionFactoryBean;
    }

    @Bean
    DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
