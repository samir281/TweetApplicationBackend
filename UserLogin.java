package com.tweetapp.tweet.payloads;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserLogin {
	@NotNull
	@Email
	private String username;
	@NotNull
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
