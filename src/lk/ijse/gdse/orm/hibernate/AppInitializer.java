package lk.ijse.gdse.orm.hibernate;


import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embedded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Main class of this Hibernate Application
 * So, let's call it as "AppInitializer"
 */
public class AppInitializer {

    /**
     * @param args : java.lang.String[]
     * Main method of this Application
     */
    public static void main(String[] args) {
        Customer customer = getCustomer();

        // 1. Save
        CustomerRepository cusRepository = new CustomerRepository();
        int savedCusId = cusRepository.saveCustomer(customer);
        System.out.println("Saved Cus Id: " + savedCusId);

        // 2. Get
        cusRepository = new CustomerRepository();
        Customer existingCustomer = cusRepository.getCustomer(savedCusId);
        System.out.println(existingCustomer);

        // 3. Update
        cusRepository = new CustomerRepository();
        existingCustomer.setAddress("Matara");
        boolean isUpdated = cusRepository.updateCustomer(existingCustomer);
        if (isUpdated) {
            System.out.println("Customer Updated!");
        } else {
            System.out.println("Customer Update Failed!");
        }

        // 4. Delete
        cusRepository = new CustomerRepository();
        boolean isDeleted = cusRepository.deleteCustomer(existingCustomer);
        if (isDeleted) {
            System.out.println("Customer Deleted!");
        } else {
            System.out.println("Customer Deletion Failed!");
        }
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
//        NameIdentifier nameIdentifier = getNameIdentifier();
//        customer.setNameIdentifier(nameIdentifier);

        customer.setName("Saman"); // <==== Add
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        customer.setAge(20); // <==== Add

//        List<MobileNo> mobileNos = getMobileNos();
//        customer.setPhoneNos(mobileNos);
        return customer;
    }

    private static List<MobileNo> getMobileNos() {
        List<MobileNo> mobileNos = new ArrayList<>();
        MobileNo homeNo = new MobileNo();
        homeNo.setType("HOME");
        homeNo.setMobileNo("0913456767");
        mobileNos.add(homeNo);

        MobileNo mobileNo = new MobileNo();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0713456767");
        mobileNos.add(mobileNo);
        return mobileNos;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Saman");
        nameIdentifier.setMiddleName("Perera");
        nameIdentifier.setLastName("De Silva");
        return nameIdentifier;
    }
}
