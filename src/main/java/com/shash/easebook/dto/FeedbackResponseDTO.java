package com.shash.easebook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shash.easebook.entities.Ads;
import com.shash.easebook.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponseDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("adId")
    private Long adId;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("review")
    private String review;

	public void setUserId(User user) {
		// TODO Auto-generated method stub
		this.userId = user.getId();
	}

	public void setAdId(Ads ad) {
		// TODO Auto-generated method stub
		this.adId =ad.getId();
	}

	public FeedbackResponseDTO(String string, Object object, Object object2, int i, Object object3) {
		// TODO Auto-generated constructor stub
	}

}