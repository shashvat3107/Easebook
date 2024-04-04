package com.shash.easebook.service;

import java.util.List;
import java.util.Optional;

import com.shash.easebook.entities.Bookings;

public interface BookingsService {

//    List<BookingsResponseDTO> getAllBookings();
	List<Bookings> getAllBookings();

    Optional<Bookings> getBookingById(Long id);

    Bookings createBooking(Bookings booking);

    Bookings updateBooking(Long id, Bookings booking);

    void deleteBooking(Long id);
}




//public interface BookingsService {
//
//    List<Bookings> getAllBookings();
//
//    Optional<Bookings> getBookingById(Long id);
//
//    List<Bookings> getBookingsByUserId(Long userId);
//
//    List<Bookings> getBookingsByAdId(Long adId);
//
//    List<Bookings> getBookingsByStatus(String status);
//
//    BookingsResponseDTO createBooking(BookingsDTO bookingDTO);
//
//    BookingsResponseDTO updateBooking(Long id, BookingsDTO updatedBooking);
//
//    void deleteBooking(Long id);
//}
