package task_7;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import task_7.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RelatedHibernateUtil {
    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = initSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            configuration.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.addAnnotatedClass(RelatedCar.class);
        configuration.addAnnotatedClass(RelatedUser.class);
        configuration.addAnnotatedClass(Phone.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Project.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
