package com.shash.easebook.dto;

import java.math.BigDecimal;

public record AdsResponseDTO(
		Long id,
		String adName,
		String photo,
		BigDecimal price,
		String description,
		Long serviceProviderId
		) {

	public Long id() {
		return id;
	}

}
