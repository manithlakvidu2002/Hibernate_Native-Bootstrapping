package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

    public int saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    public Customer getCustomer(int id) {
        try {
            Customer customer = session.get(Customer.class, id);
            session.close();
            return customer;

//            return session.get(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer> getAllCustomerJPQL() {
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }
    public Customer getCustomerById(int id) {
        String sql = "SELECT C FROM Customer AS C WHERE C.id = :cus_id";
        Query namedQuery = session.createQuery(sql);
        namedQuery.setParameter("cus_id", id);
        Customer customer = (Customer) namedQuery.getSingleResult();
        session.close();
        return customer;
    }
}
