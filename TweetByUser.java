package com.tweetapp.tweet.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
public class TweetByUser {
	private int id;
	private String descip;
	private String username;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescip() {
		return descip;
	}
	public void setDescip(String descip) {
		this.descip = descip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
