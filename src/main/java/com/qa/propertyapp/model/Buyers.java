package com.qa.propertyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Buyers {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private String first_name;
    private String surname;
    private String email;
    private String address;
    private String postcode;
    private int phone_number;


    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public List<Sellers> getSellers() {
        return sellers;
    }
    public void setSellers(List<Sellers> sellers) {
        this.sellers = sellers;
    }


    @OneToMany(mappedBy = "buyers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Sellers> sellers;

    @Override
    public String toString() {
        return "Buyers{" +
                "Id=" + Id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone_number=" + phone_number +
                ", sellers=" + sellers +
                '}';
    }
}