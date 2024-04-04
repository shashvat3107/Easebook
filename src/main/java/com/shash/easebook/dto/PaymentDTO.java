package com.shash.easebook.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDTO(
        Long userId,
        Long adId,
        BigDecimal amount,
        LocalDate paymentDate
) {
}