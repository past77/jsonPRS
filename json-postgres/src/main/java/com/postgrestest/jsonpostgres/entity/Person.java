package com.postgrestest.jsonpostgres.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "json", name = "personData")
public class Person {
    @Id
    @GeneratedValue
    private Long pk;

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAdress;
//    private String country;
//   private Long id;
//    private String total;
//    private String offset;
    private String offs12et;
    private String off23set;
    private String offs534et;

    public Person() {
    }

    public String getOffs12et() {
        return offs12et;
    }

    public void setOffs12et(String offs12et) {
        this.offs12et = offs12et;
    }

    public String getOff23set() {
        return off23set;
    }

    public void setOff23set(String off23set) {
        this.off23set = off23set;
    }

    public String getOffs534et() {
        return offs534et;
    }

    public void setOffs534et(String offs534et) {
        this.offs534et = offs534et;
    }

    //    public String getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        this.total = total;
//    }

//    public String getOffset() {
//        return offset;
//    }
//
//    public void setOffset(String offset) {
//        this.offset = offset;
//    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAddress) {
        this.ipAdress = ipAddress;
    }

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
}
