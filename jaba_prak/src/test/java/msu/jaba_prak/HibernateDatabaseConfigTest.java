package msu.jaba_prak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.validation.annotation.Validated;

import static org.junit.Assert.assertNotNull;

@Configuration
@PropertySource("classpath:application.properties")
public class HibernateDatabaseConfigTest{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Test
    public void test(){
        SessionFactory sessionFactoryObject = sessionFactory.getObject();
        assertNotNull(sessionFactoryObject);
        Session session = sessionFactoryObject.openSession();
        assertNotNull(session);
    }


}
