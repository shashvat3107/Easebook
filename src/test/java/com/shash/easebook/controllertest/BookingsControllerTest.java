package com.shash.easebook.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shash.easebook.controller.BookingsController;
import com.shash.easebook.entities.Bookings;
import com.shash.easebook.service.BookingsService;

public class BookingsControllerTest {
	@Mock
	private BookingsService bookingsService;

	@InjectMocks
	private BookingsController bookingsController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllBookings() {
		// Mock data
		List<Bookings> bookingsList = new ArrayList<>();
		when(bookingsService.getAllBookings()).thenReturn(bookingsList);

		// Call controller method
		ResponseEntity<List<Bookings>> result = bookingsController.getAllBookings();

		// Verify result
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(bookingsList, result.getBody());
	}

	@Test
	void testGetBookingById_Positive() {
		// Mock data
		Long id = 1L;
		Bookings booking = new Bookings(/* initialize booking object */);
		when(bookingsService.getBookingById(id)).thenReturn(Optional.of(booking));

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.getBookingById(id);

		// Verify result
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(booking, result.getBody());
	}

	@Test
	void testGetBookingById_Negative() {
		// Mock data
		Long id = 1L;
		when(bookingsService.getBookingById(id)).thenReturn(Optional.empty());

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.getBookingById(id);

		// Verify result
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	}

	@Test
	void testCreateBooking_Positive() {
		// Mock data
		Bookings bookingDto = new Bookings(/* initialize booking DTO object */);
		Bookings createdBooking = new Bookings(/* initialize created booking object */);
		when(bookingsService.createBooking(bookingDto)).thenReturn(createdBooking);

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.createBooking(bookingDto);

		// Verify result
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertEquals(createdBooking, result.getBody());
	}

	@Test
	void testCreateBooking_Negative() {
		// Mock data
		Bookings booking = new Bookings(/* initialize invalid booking DTO object */);
		when(bookingsService.createBooking(booking)).thenReturn(null);

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.createBooking(booking);

		// Verify result
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		assertNotNull(result.getBody());
	}

	@Test
	void testUpdateBooking_Positive() {
		// Mock data
		Long id = 1L;
		Bookings booking = new Bookings(/* initialize booking DTO object */);
		Bookings updatedBooking = new Bookings(/* initialize updated booking object */);
		when(bookingsService.updateBooking(id, booking)).thenReturn(updatedBooking);

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.updateBooking(id, booking);

		// Verify result
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(updatedBooking, result.getBody());
	}

	@Test
	void testUpdateBooking_Negative() {
		// Mock data
		Long id = 1L;
		Bookings booking = new Bookings(/* initialize invalid booking DTO object */);
		when(bookingsService.updateBooking(id, booking)).thenReturn(null);

		// Call controller method
		ResponseEntity<Bookings> result = bookingsController.updateBooking(id, booking);

		// Verify result
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	}

	@Test
	void testDeleteBooking() {
		// Mock data
		Long id = 1L;

		// Call controller method
		ResponseEntity<String> result = bookingsController.deleteBooking(id);

		// Verify result
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals("Booking deleted successfully!", result.getBody());
		verify(bookingsService, times(1)).deleteBooking(id);
	}
}
