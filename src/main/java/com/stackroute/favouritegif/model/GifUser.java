package com.stackroute.favouritegif.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class GifUser {


	@Id
	private String userId;
	private List<String> gifId;

	// Constructors
	public GifUser() {
	}

	public GifUser(String userId, List<String> gifId) {
		this.userId = userId;
		this.gifId = gifId;
	}

	// Getters and setters

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getGifIds() {
		return gifId;
	}

	public void setGifIds(List<String> gifId) {
		this.gifId = gifId;
	}





}
