package lk.ijse.gdse.orm;

import lk.ijse.gdse.orm.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.embedded.MobileNo;
import lk.ijse.gdse.orm.embedded.NameIdentifier;
import lk.ijse.gdse.orm.entity.Customer;
import lk.ijse.gdse.orm.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {

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
        customer.setId(2);
        NameIdentifier nameIdentifier = getNameIdentifier();
        customer.setNameIdentifier(nameIdentifier);
        customer.setAddress("Matara");
        customer.setSalary(25000.00);

        List<MobileNo> mobileNos = getMobileNos();
        customer.setPhoneNos(mobileNos);
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
        mobileNo.setMobileNo("0771286508");
        mobileNos.add(mobileNo);
        return mobileNos;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Bopage");
        nameIdentifier.setMiddleName("Chaminda");
        nameIdentifier.setLastName("Jayarathna");
        return nameIdentifier;
    }
}
