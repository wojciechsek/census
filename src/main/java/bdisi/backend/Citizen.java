package bdisi.backend;

import org.hibernate.Session;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class Citizen {
  // TODO: odpowiednie metody, które wywoła potem gui
  Session session;
  String myPesel;

  public Citizen(String pesel) {
    myPesel = pesel;
  }

  public String PrintPersonalData() {
    StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("displayCityStats");
    procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
    procedureQuery.setParameter("pesel", myPesel);
    procedureQuery.execute();

    return (String) procedureQuery.getOutputParameterValue("result");
  }

  public void changePassword(String oldPassword, String newPassword) {
    StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("changePassword");
    procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("oldPassword", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("newPassword", String.class, ParameterMode.IN);
    procedureQuery.setParameter("pesel", myPesel);
    procedureQuery.setParameter("oldPassword", oldPassword);
    procedureQuery.setParameter("oldPassword", newPassword);
    procedureQuery.execute();
  }

  public void changeAddress(String city, String street, int house, int flat) {
    StoredProcedureQuery procedureQuery = session.createStoredProcedureQuery("changePassword");
    procedureQuery.registerStoredProcedureParameter("pesel", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("city", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("street", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("house", Integer.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("flat", Integer.class, ParameterMode.IN);
    procedureQuery.setParameter("pesel", myPesel);
    procedureQuery.setParameter("city", city);
    procedureQuery.setParameter("street", street);
    procedureQuery.setParameter("house", house);
    procedureQuery.setParameter("flat", flat);
    procedureQuery.execute();
  }
}
