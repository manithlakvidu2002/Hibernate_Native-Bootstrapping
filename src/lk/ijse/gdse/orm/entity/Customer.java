package lk.ijse.gdse.orm.entity;

import lk.ijse.gdse.orm.embedded.MobileNo;
import lk.ijse.gdse.orm.embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//1. 1st way to define table name => @Entity(name = "customer")
//2. 2nd way to define table name =>
//   @Entity
//   @Table(name = "customer")
@Entity
@Table(name = "customer")
public class Customer {

    @Id // Tells hibernate that this is the primary key of this entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false, length = 50) // defines how the column name should be generated in database
    private int id;
    private NameIdentifier nameIdentifier;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;
    @Transient
    private String dob;
    @CreationTimestamp
    private Timestamp createdDateTime;
    @ElementCollection
    @CollectionTable(name = "customer_mobile_nos",
            joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobileNo> phoneNos = new ArrayList<>();

    @Column(name = "customer_age" , columnDefinition = "TinyInt")
    private int age;

    public Customer() {}

    public Customer(int id, NameIdentifier nameIdentifier, String address, double salary, String dob, Timestamp createdDateTime, List<MobileNo> phoneNos) {
        this.id = id;
        this.nameIdentifier = nameIdentifier;
        this.address = address;
        this.salary = salary;
        this.dob = dob;
        this.createdDateTime = createdDateTime;
        this.phoneNos = phoneNos;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public NameIdentifier getNameIdentifier() {
        return nameIdentifier;
    }

    public void setNameIdentifier(NameIdentifier nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<MobileNo> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(List<MobileNo> phoneNos) {
        this.phoneNos = phoneNos;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + nameIdentifier.toString() + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
