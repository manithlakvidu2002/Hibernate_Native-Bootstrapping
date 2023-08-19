package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.entity.Order;
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

        System.out.println("---------JPQL JOIN-------");

        CustomerRepository customerRepository2 = new CustomerRepository();
        List<Order> orders = customerRepository2.getOrdersByCustomerId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
