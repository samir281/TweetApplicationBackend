package com.tweetapp.tweet.payloads;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 
@NoArgsConstructor
@AllArgsConstructor
public class TweetDto {
	
	private int id;
	@NotNull
	private String discription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
//	public TweetDto(Integer id2, String description) {
//		// TODO Auto-generated constructor stub
//		this.id=id2;
//		this.discription=description;
//	}
//	
	
}
