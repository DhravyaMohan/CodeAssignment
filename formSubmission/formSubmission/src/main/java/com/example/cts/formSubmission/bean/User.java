package com.example.cts.formsubmission.bean;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    private String contactNo;
    private int age;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "contact_no", nullable = false)
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(long id, String firstName, String lastName, String emailId, String address, String contactNo, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.address = address;
        this.contactNo = contactNo;
        this.age = age;
    }
}
