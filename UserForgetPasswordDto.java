package com.tweetapp.tweet.payloads;

import javax.validation.constraints.Email;

import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserForgetPasswordDto {
	@NotNull
	@Email
	private String username;
	@NotNull
	private String newpassword;
	@NumberFormat
//	@Size(max=10)
	private String phonenumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
