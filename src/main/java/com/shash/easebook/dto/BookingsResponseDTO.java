package com.shash.easebook.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsResponseDTO {
    public BookingsResponseDTO(String string, Object userId2, Object adId2, Object date2, Object status2) {
		// TODO Auto-generated constructor stub
	}
	private Long id;
    private Long userId;
    private Long adId;
    private LocalDate date;
    private String status;
}