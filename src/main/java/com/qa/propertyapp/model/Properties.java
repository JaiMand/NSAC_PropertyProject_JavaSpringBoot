package com.qa.propertyapp.model;

import jakarta.persistence.*;

@Table (name= "properties")
@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String postcode;
    private double price;
    private String status;
//    private enum status{
//        FOR_SALE,
//        WITHDRAW,
//        SOLD
//    };
    private String type;
    private int bedrooms;
    private int bathrooms;
    private boolean garden;

    public Properties() {
    }

    public Properties(long id, String address, String postcode, double price, String status,
                      String type, int bedrooms, int bathrooms, boolean garden, Sellers sellers,
                      Buyers buyers) {
        this.id = id;
        this.address = address;
        this.postcode = postcode;
        this.type = type;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.status = status;
        this.sellers = sellers;
        this.buyers = buyers;
    }

    public long getId() {
        return id;
    }
    public void setId(long Id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean getGarden() {
        return garden;
    }
    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Sellers getSellers() {
        return sellers;
    }
    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }

    public Buyers getBuyers() {
        return buyers;
    }
    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }

    @ManyToOne//(cascade = CascadeType.ALL)
    private Buyers buyers;
    @ManyToOne//(cascade = CascadeType.ALL)
    private Sellers sellers;

    @Override
    public String toString() {
        return "Properties{" +
                "id=" + id +
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