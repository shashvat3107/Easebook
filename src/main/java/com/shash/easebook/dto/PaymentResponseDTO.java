package com.shash.easebook.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResponseDTO(
        Long id,
        Long userId,
        Long adId,
        BigDecimal amount,
        LocalDate paymentDate
) {
}
