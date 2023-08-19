package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class PersistentState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance()
                .getSession();

        // Transient State
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        customer.setAge(20);

        System.out.println(
                isExistsInSession(session, customer));

        // Persistent State
        int cusId = (int) session.save(customer);

        System.out.println(
                isExistsInSession(session, customer));

        session.close();
    }

    private static String isExistsInSession(Session session, Customer customer) {
        return session.contains(customer)
                ? "This Object is in Persistent State"
                : "This object is in Transient State";
    }
}
