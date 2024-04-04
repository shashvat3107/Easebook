package com.shash.easebook.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shash.easebook.entities.Bookings;
import com.shash.easebook.repository.BookingsRepository;
import com.shash.easebook.service.impl.BookingsServiceImpl;

public class BookingsServiceImplTest {
	@Mock
    private BookingsRepository bookingRepository;

    @InjectMocks
    private BookingsServiceImpl bookingsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    void testGetAllBookings_Positive() {
        // Mock data
        List<Bookings> bookings = new ArrayList<>();
        when(bookingRepository.findAll()).thenReturn(bookings);

        // Call service method
        List<Bookings> result = bookingsService.getAllBookings();

        // Verify result
        assertNotNull(result);
        assertEquals(bookings, result);
    }

    
    @Test
    void testGetAllBookings_Negative() {
        // Mock repository to return null
        when(bookingRepository.findAll()).thenReturn(null);

        // Call service method
        List<Bookings> result = bookingsService.getAllBookings();

        // Verify result
        assertNull(result);
    }

    @Test
    void testGetBookingById_Positive() {
        // Mock data
        Long id = 1L;
        Bookings booking = new Bookings(/* initialize Booking object */);
        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        // Call service method
        Optional<Bookings> result = bookingsService.getBookingById(id);

        // Verify result
        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
    }

    @Test
    void testGetBookingById_Negative() {
        // Mock data
        Long id = 1L;

        // Call service method
        Optional<Bookings> result = bookingsService.getBookingById(id);

        // Verify result
        assertFalse(result.isPresent());
    }
    
    @Test
    void testCreateBooking_Positive() {
        // Mock data
        Bookings booking = new Bookings(/* initialize Booking object */);
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Call service method
        Bookings result = bookingsService.createBooking(booking);

        // Verify result
        assertNotNull(result);
        assertEquals(booking, result);
    }

    @Test
    void testCreateBooking_Negative() {
        // Mock data
        Bookings booking = null; // Invalid booking object

        // Call service method
        Bookings result = bookingsService.createBooking(booking);

        // Verify result
        assertNull(result);
    }

    @Test
    void testUpdateBooking_Positive() {
        // Mock data
        Long id = 1L;
        Bookings booking = new Bookings(/* initialize Booking object */);
        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Call service method
        Bookings result = bookingsService.updateBooking(id, booking);

        // Verify result
        assertNotNull(result);
        assertEquals(booking, result);
    }

    @Test
    void testUpdateBooking_Negative() {
        // Mock data
        Long id = 1L;
        Bookings booking = new Bookings(/* initialize Booking object */);

        // Call service method
        Bookings result = bookingsService.updateBooking(id, booking);

        // Verify result
        assertNull(result);
    }

    @Test
    void testDeleteBooking_Positive() {
        // Mock data
        Long id = 1L;
        Bookings booking = new Bookings(/* initialize Booking object */);
        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        // Call service method
        bookingsService.deleteBooking(id);

        // Verify if deleteById was called once
        verify(bookingRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteBooking_Negative() {
        // Mock data
        Long id = 1L;

        doThrow(IllegalArgumentException.class).when(bookingRepository).deleteById(id);
        // Call service method
        assertThrows(IllegalArgumentException.class, () -> bookingsService.deleteBooking(id));
    }

}
