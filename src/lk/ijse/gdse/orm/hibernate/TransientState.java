package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class TransientState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance()
                .getSession();
        // Transient
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        customer.setAge(20);
        System.out.println(
                isExistsInSession(session, customer));
    }

    private static String isExistsInSession(Session session, Customer customer) {
        return session.contains(customer)
                ? "This object is not Transient"
                : "This object is in Transient State";
    }
}
