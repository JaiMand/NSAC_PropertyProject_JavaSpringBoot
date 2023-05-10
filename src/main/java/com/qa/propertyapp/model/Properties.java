package com.qa.propertyapp.model;

import jakarta.persistence.*;

@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String address;
    private String postcode;
    private String price;
    private String status;
    private String type;
    private String bedrooms;
    private String bathrooms;
    private String garden;
    private String seller_id_fk;

    public Properties() {
    }

    public Properties(long Id, String address, String postcode, String price, String status, String type, String bedrooms, String bathrooms, String garden, String seller_id_fk, Sellers sellers) {
        this.Id = Id;
        this.address = address;
        this.postcode = postcode;
        this.type = type;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.status = status;
        this.seller_id_fk = seller_id_fk;
        this.sellers = sellers;
    }

    public long getId() {
        return Id;
    }
    public void setId(long Id) {
        this.Id = Id;
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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getGarden() {
        return garden;
    }
    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeller_id_fk() {
        return seller_id_fk;
    }
    public void setSeller_id_fk(String seller_id_fk) {
        this.seller_id_fk = seller_id_fk;
    }

    public Sellers getSellers() {
        return sellers;
    }
    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }


    @ManyToOne
    private Sellers sellers;

    public Sellers get() {
        return sellers;
    }
    public void setEmployee(Sellers sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "Id=" + Id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", bedrooms='" + bedrooms + '\'' +
                ", bathrooms='" + bathrooms + '\'' +
                ", garden='" + garden + '\'' +
                ", sellers=" + sellers +
                '}';
    }
}