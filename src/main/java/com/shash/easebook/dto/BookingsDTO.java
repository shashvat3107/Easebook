package com.shash.easebook.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingsDTO {
    private Long userId;
    private Long adId;
    private LocalDate date;
    private String status;
}
