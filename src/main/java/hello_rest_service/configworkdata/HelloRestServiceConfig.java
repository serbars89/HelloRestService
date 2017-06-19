package hello_rest_service.configworkdata;

import hello_rest_service.dao.ContactDao;
import hello_rest_service.dao.ContactDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("hello_rest_service")
@EnableCaching
@EnableTransactionManagement
public class HelloRestServiceConfig {

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.scanPackages("hello_rest_service");

        return sessionBuilder.buildSessionFactory();

    }

    @Bean(name = "dataSource")
    DataSource dataSource() {

        return  new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("myTestDB")
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql").build();

    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Bean(name = "contactDao")
    public ContactDao getContactDao(SessionFactory sessionFactory) {
        return new ContactDaoImpl(sessionFactory);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("contacts");
    }

}
