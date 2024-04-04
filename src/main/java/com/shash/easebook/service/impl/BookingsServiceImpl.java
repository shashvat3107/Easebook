package com.shash.easebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shash.easebook.entities.Bookings;
import com.shash.easebook.repository.BookingsRepository;
import com.shash.easebook.service.BookingsService;



@Service
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;

    @Autowired
    public BookingsServiceImpl(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @Override
    public List<Bookings> getAllBookings() {
//        List<Booking> bookings = bookingsRepository.findAll();
//        List<Bookings> bookings = bookingsRepository.findAllBookings();
    	List<Bookings> bookings = bookingsRepository.findAll();
        return bookings;
//        return bookings.stream()
//                .map(this::mapEntityToDto)
//                .collect(Collectors.toList());
    }

    @Override
    public Optional<Bookings> getBookingById(Long id) {
        Optional<Bookings> bookingOptional = bookingsRepository.findById(id);
        return bookingOptional;//.map(this::mapEntityToDto);
    }

    @Override
    public Bookings createBooking(Bookings booking) {
//        Bookings booking = mapDtoToEntity(bookingDto);
    	
        booking = bookingsRepository.save(booking);
        return booking;
//        return mapEntityToDto(booking);
    }

    @Override
    public Bookings updateBooking(Long id, Bookings booking) {
        Optional<Bookings> existingBookingOptional = bookingsRepository.findById(id);
        if (existingBookingOptional.isPresent()) {
            Bookings existingBooking = existingBookingOptional.get();
            existingBooking.setUserId(booking.getUserId());
            existingBooking.setAdId(booking.getAdId());
            existingBooking.setDate(booking.getDate());
            existingBooking.setStatus(booking.getStatus());

            existingBooking = bookingsRepository.save(existingBooking);
            return existingBooking;
//            return mapEntityToDto(existingBooking);
        }
        return null; // Handle not found case as needed
    }

    @Override
    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }

//    private BookingsResponseDTO mapEntityToDto(Bookings booking) {
//        return new BookingsResponseDTO(
//                booking.getId(),
//                booking.getUserId(),
//                booking.getAdId(),
//                booking.getDate(),
//                booking.getStatus()
//        );
//    }

//    private Bookings mapDtoToEntity(BookingsDTO bookingDto) {
//        return new Bookings(
//        		null,
//                bookingDto.getUserId(),
//                bookingDto.getAdId(),
//                bookingDto.getDate(),
//                bookingDto.getStatus()
//        );
//    }
}