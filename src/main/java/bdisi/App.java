package bdisi;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(registryBuilder.build());
    }

    public static void main( String[] args ) {
        Session session = App.getSessionFactory().openSession();

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "censuspersistence" );

        EntityManager entityManager = emfactory.createEntityManager( );

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("printPersonalData")
                .registerStoredProcedureParameter("pesel", String.class,
                        ParameterMode.IN)
                .registerStoredProcedureParameter("result", String.class,
                        ParameterMode.OUT)
                .setParameter("pesel", "00291407177");

        query.execute();


        /*StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayCityStats");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
        procedureQuery.setParameter("pesel", "00291407177");
        procedureQuery.execute();

        String dupa = (String) procedureQuery.getOutputParameterValue("result");*/
        System.out.println("Hello World!");
    }
}
