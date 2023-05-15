package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Bookings;
import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.BookingRepo;
import com.qa.propertyapp.repo.BuyerRepo;
import com.qa.propertyapp.repo.PropertyRepo;
import com.qa.propertyapp.repo.SellerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private SellerRepo sellerRepo;
    @Autowired
    private BuyerRepo buyerRepo;

    public BookingService(BookingRepo bookingRepo, PropertyRepo propertyRepo,
                          SellerRepo sellerRepo, BuyerRepo buyerRepo){
        this.bookingRepo = bookingRepo;
        this.propertyRepo = propertyRepo;
        this.sellerRepo = sellerRepo;
        this.buyerRepo = buyerRepo;
    }

    public BookingService(){ }

    public List<Bookings> getAll() {
        return this.bookingRepo.findAll();
    }

    public Bookings getBooking (long id) {
        Optional<Bookings> booking = this.bookingRepo.findById(id);
        if (booking.isPresent()){
            return booking.get();
        }
        throw new EntityNotFoundException("Booking With id " + id + " Not Found");
    }

    public Bookings createBooking (Bookings booking){
        if (booking.getSeller() == null) {
            throw new RuntimeException("Cannot Create A New Booking Without A Seller");
        }
        Optional<Sellers> seller = this.sellerRepo.findById(booking.getSeller().getId());
        if (!seller.isPresent()){
            throw new EntityNotFoundException("Cannot Create Booking, Seller With id " + booking.getSeller().getId() + " Is Not Found");
        }
        else booking.setSeller(seller.get());

        if (booking.getProperty() == null) {
            throw new RuntimeException("Cannot Create A New Booking Without A Property");
        }
        Optional<Properties> property = this.propertyRepo.findById(booking.getProperty().getId());
        if (!property.isPresent()){
            throw new EntityNotFoundException("Cannot Create Booking, Property With id " + booking.getProperty().getId() + " Is Not Found");
        }
        else booking.setProperty(property.get());

        if (booking.getBuyer() == null) {
            throw new RuntimeException("Cannot Create A New Booking Without A Buyer");
        }
        Optional<Buyers> buyer = this.buyerRepo.findById(booking.getBuyer().getId());
        if (!buyer.isPresent()){
            throw new EntityNotFoundException("Cannot Create Booking, Buyer With id " + booking.getBuyer().getId() + " Is Not Found");
        }
        else booking.setBuyer(buyer.get());

        return this.bookingRepo.save(booking);
    }

    public Bookings deleteBooking (long id){
        Bookings removed = this.getBooking(id);
        this.bookingRepo.deleteById(id);
        return removed;
    }

    public Bookings updateBooking (Bookings newBooking, long id) {
        Bookings bookingToUpdate = this.getBooking(id);
        if (newBooking.getDate() != null) {
            bookingToUpdate.setDate(newBooking.getDate());
        }
        if (newBooking.getTime() != null) {
            bookingToUpdate.setTime(newBooking.getTime());
        }
        return this.bookingRepo.save(bookingToUpdate);
    }
}
