package bdisi.backend;

import org.hibernate.Session;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class Bureaucrat extends Citizen {
    // TODO: odpowiednie metody, które wywoła potem gui
    Session session;

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
