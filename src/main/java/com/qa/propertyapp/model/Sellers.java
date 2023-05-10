package com.qa.propertyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String first_name;
    private String surname;
    private String email;
    private String address;
    private String postcode;
    private int phone_number;


    public Sellers() {
    }

    public Sellers(long id, String first_name, String surname, String email, String address, String postcode, int phone_number, Buyers buyers, List<Properties> propertiesList) {
        this.Id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone_number = phone_number;
        this.buyers = buyers;
        this.propertiesList = propertiesList;
    }


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

    public Buyers getBuyers() {
        return buyers;
    }
    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }

    public List<Properties> getPropertiesList() {
        return propertiesList;
    }
    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }


    @ManyToOne
    private Buyers buyers;

    @OneToMany(mappedBy = "sellers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;


    @Override
    public String toString() {
        return "Sellers{" +
                "Id=" + Id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone_number=" + phone_number +
                ", buyers=" + buyers +
                ", propertiesList=" + propertiesList +
                '}';
    }
}