package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;

import java.util.List;

public class SqlQueryEvaluator {
    public static void main(String[] args) {

        System.out.println("------JPQL Get All-----------");
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> allCustomerNative = customerRepository.getAllCustomerJPQL();
        for (Customer customer : allCustomerNative) {
            System.out.println(customer);
        }

        System.out.println("----------JPQL Where--------");
        CustomerRepository customerRepository1 = new CustomerRepository();
        Customer customerById = customerRepository1.getCustomerById(1);
        System.out.println(customerById);
    }
}
