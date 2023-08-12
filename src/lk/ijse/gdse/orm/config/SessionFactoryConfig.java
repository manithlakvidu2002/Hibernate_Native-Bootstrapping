package lk.ijse.gdse.orm.config;

/*This is the Session Factory Config*/

import lk.ijse.gdse.orm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig{


    private static  SessionFactoryConfig factoryConfig;
    private static SessionFactory  sessionFactory;
    private SessionFactoryConfig(){

        /*sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().loadProperties("Hibernate.properties").build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build().buildSessionFactory();
*/      //Standed Bootstrapping
        sessionFactory =new Configuration().addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        /*if (null == factoryConfig
            return factoryConfig = new SessionFactoryConfig();
        }
        return factoryConfig;*/
        return (null == factoryConfig)? factoryConfig = new SessionFactoryConfig(): factoryConfig;
    }
    public Session getSession(){
        /*create a service registry*/

        return sessionFactory.openSession();
    }

}
