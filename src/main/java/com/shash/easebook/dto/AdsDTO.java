package com.shash.easebook.dto;

import java.math.BigDecimal;

public record AdsDTO(
		String adName,
		String photo,
		BigDecimal price,
		String description,
		Long serviceProviderId
		) {

//	public String adName() {
//		return adName;
//	}
//
//	public String photo() {
//		return photo;
//	}
//
//	public BigDecimal price() {
//		return price;
//	}
//
//	public String description() {
//		return description;
//	}
//
//	public Long serviceProviderId() {
//		return serviceProviderId;
//	}

}
