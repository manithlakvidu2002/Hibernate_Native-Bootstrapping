package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;

import java.util.List;

public class SqlQueryEvaluator {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> allCustomerNative = customerRepository.getAllCustomerJPQL();
        for (Customer customer : allCustomerNative) {
            System.out.println(customer);
        };
    }
}
