package com.qa.propertyapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "booking")
@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Properties property;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Sellers seller;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyers buyer;

    public Bookings() {}

    public Bookings(long id, LocalDate date, LocalTime time, Properties property,
                    Buyers buyer, Sellers seller) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.property = property;
        this.seller = seller;
        this.buyer = buyer;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Properties getProperty() {
        return property;
    }

    public void setProperty(Properties property) {
        this.property = property;
    }

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    public Buyers getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyers buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", property=" + property +
                ", seller=" + seller +
                ", buyer=" + buyer +
                '}';
    }
}