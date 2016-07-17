package com.harvey;

import com.harvey.common.core.dao.DefaultNativeSqlDao;
import com.harvey.common.core.dao.DefaultUniversalDao;
import com.harvey.common.core.hibernate.HibernateEntityClassesFactoryBean;
import com.harvey.common.core.hibernate.HibernateMappingLocationsFactoryBean;
import com.harvey.learning.springboot.listener.MyApplicationStartedEventListener;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.Properties;

/**
 * Created by harvey on 16/7/14.
 */
@SpringBootApplication
public class Application {
    public  static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run("classpath:applicationContext-core.xml",args);
//        app.run(args);
    }
    @Bean
    PoolProperties poolProperties(){
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl("jdbc:mysql://localhost:3306/test");
        poolProperties.setUsername("root" );
        poolProperties.setPassword("root");
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setRemoveAbandonedTimeout(300);
        poolProperties.setMaxActive(100);
        poolProperties.setMaxIdle(100);
        poolProperties.setMinIdle(5);
        poolProperties.setMaxWait(2000);
        poolProperties.setValidationQuery("select 1");
        poolProperties.setDefaultAutoCommit(true);
        poolProperties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport(threshold=2000)" );
        poolProperties.setTestWhileIdle(true);

        return poolProperties;
    }

    @Bean
    DataSource dataSource(){
        DataSource dataSource = new DataSource(poolProperties());
        return dataSource;

    }

    @Bean
    LocalSessionFactoryBean sessionFactory() throws Exception {
        LocalSessionFactoryBean sessionFactory =new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql","true");
        hibernateProperties.put("hibernate.format_sql","false");
        hibernateProperties.put("hibernate.use_sql_comments","true");
        hibernateProperties.put("hibernate.cache.provider_class","net.sf.ehcache.hibernate.EhCacheProvider");
        hibernateProperties.put("hibernate.cache.region.factory_class","org.hibernate.cache.SingletonEhCacheRegionFactory");
        sessionFactory.setHibernateProperties(hibernateProperties);

        HibernateEntityClassesFactoryBean annotatedClasses = new HibernateEntityClassesFactoryBean();
        annotatedClasses.setBasePackages("com.harvey");
        sessionFactory.setAnnotatedClasses(annotatedClasses.getClass());

        HibernateMappingLocationsFactoryBean mappingLocations = new  HibernateMappingLocationsFactoryBean();
        mappingLocations.setBasePackages("com.harvey");
        sessionFactory.setMappingLocations(mappingLocations.getObject());
        return sessionFactory;
    }
    @Bean
    HibernateTransactionManager transactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory((SessionFactory) sessionFactory());
        return transactionManager;

    }

    @Bean
    DefaultUniversalDao universalDao() throws Exception {
        DefaultUniversalDao universalDao = new DefaultUniversalDao();
        universalDao.setSessionFactory((SessionFactory) sessionFactory());
        return universalDao;
    }

    @Bean
    DefaultNativeSqlDao nativeSqlDao() throws Exception {
        DefaultNativeSqlDao nativeSqlDao = new DefaultNativeSqlDao();
        nativeSqlDao.setSessionFactory((SessionFactory) sessionFactory());
        return nativeSqlDao;
    }
}
