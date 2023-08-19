package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class RemovedState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance().getSession();

        Customer customer = session.get(Customer.class, 1);

        System.out.println(
                isExistsInSession(session, customer));

        session.delete(customer);

        System.out.println(
                isExistsInSession(session, customer));

        session.close();
    }

    private static String isExistsInSession(Session session, Customer customer) {
        return session.contains(customer)
                ? "This Object is in Persistent State"
                : "This object is in Removed State";
    }
}
