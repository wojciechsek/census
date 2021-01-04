package bdisi.backend;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class Admin extends Bureaucrat {
  // TODO: odpowiednie metody, które wywoła potem gui

    public String addBureaucrat(String pesel, String password, String name, String surname, String city, String street, int house, int flat) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("changeStatus");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("surname", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("city", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("street", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("house", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("flat", Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
        procedureQuery.setParameter("pesel", pesel);
        procedureQuery.setParameter("password", password);
        procedureQuery.setParameter("name", name);
        procedureQuery.setParameter("surname", surname);
        procedureQuery.setParameter("city", city);
        procedureQuery.setParameter("street", street);
        procedureQuery.setParameter("house", house);
        procedureQuery.setParameter("flat", flat);
        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("result");
    }

    public String deleteBureaucrat(String pesel) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("changeStatus");
        procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("status", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
        procedureQuery.setParameter("pesel", pesel);
        procedureQuery.setParameter("status", "Bureaucrat");
        procedureQuery.execute();

        return (String) procedureQuery.getOutputParameterValue("result");
    }

    public void changeStatus(String pesel, String status) {
        StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("changeStatus");
        procedureQuery.registerStoredProcedureParameter("spesel", String.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter("newStatus", String.class, ParameterMode.IN);
        procedureQuery.setParameter("spesel", pesel);
        procedureQuery.setParameter("newStatus", status);
        procedureQuery.execute();
    }
}
