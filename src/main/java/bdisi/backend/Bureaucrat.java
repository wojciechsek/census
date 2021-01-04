package bdisi.backend;

import org.hibernate.Session;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class Bureaucrat extends Citizen {
    // TODO: odpowiednie metody, które wywoła potem gui
    Session session;

    public Bureaucrat(String pesel) {
        super(pesel);
    }

    public String PrintPersonalData(String pesel) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayCityStats");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
        procedureQuery.setParameter("pesel", pesel);
        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("result");
    }

    public void addCitizen(String pesel, String password, String name, String surname, String city, String street, int house, int flat) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("addCitizen");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("status", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("surname", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("city", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("street", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("house", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("flat", Integer.class, ParameterMode.IN);
        procedureQuery.setParameter("pesel", pesel);
        procedureQuery.setParameter("status", "Citizen");
        procedureQuery.setParameter("password", password);
        procedureQuery.setParameter("name", name);
        procedureQuery.setParameter("surname", surname);
        procedureQuery.setParameter("city", city);
        procedureQuery.setParameter("street", street);
        procedureQuery.setParameter("house", house);
        procedureQuery.setParameter("flat", flat);
        procedureQuery.execute();
    }

    public String deleteCitizen(String pesel, String status) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("addCitizen");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("status", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);

        procedureQuery.setParameter("pesel", pesel);
        procedureQuery.setParameter("status", status);
        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("result");
    }
    public int displayCityStats(String city) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayCityStats");
        procedureQuery.registerStoredProcedureParameter("city", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT);
        procedureQuery.setParameter("city", city);
        procedureQuery.execute();

        return (int) procedureQuery.getOutputParameterValue("result");
    }

    public int displayGenderStats(String gender) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayGenderStats");
        procedureQuery.registerStoredProcedureParameter("sgender", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT);
        procedureQuery.setParameter("sgender", gender);
        procedureQuery.execute();

        return (int) procedureQuery.getOutputParameterValue("result");
    }

    public int displayYearStats(int year) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayYearStats");
        procedureQuery.registerStoredProcedureParameter("syear", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT);
        procedureQuery.setParameter("syear", year);
        procedureQuery.execute();

        return (int) procedureQuery.getOutputParameterValue("result");
    }

    public String displayStatus(String pesel) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayStatus");
        procedureQuery.registerStoredProcedureParameter("spesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
        procedureQuery.setParameter("spesel", pesel);
        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("result");
    }
}
