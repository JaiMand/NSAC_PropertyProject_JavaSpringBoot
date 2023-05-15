package com.qa.propertyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Table (name= "buyer")
@Entity
public class Buyers {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String first_name;
    private String surname;
    @Email
    private String email;
    private String address;
    private String postcode;
    @Size(max = 11, min = 11, message = "Phone number must be 11 characters long")
    private String phone_number;


    public Buyers() {
    }
    public Buyers(long id, String first_name, String surname, String email,
                  String address, String postcode, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone_number = phone_number;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    @ManyToOne
    private Properties property;

    @OneToMany(mappedBy = "buyers", fetch = FetchType.EAGER, cascade = {
            CascadeType.REMOVE
    })
    @JsonIgnore
    private List<Properties> propertiesList;

//    @OneToMany(mappedBy = "buyers", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Properties> properties;

    @Override
    public String toString() {
        return "Buyers{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }
}