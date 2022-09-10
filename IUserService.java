package com.tweetapp.tweet.service;

import java.util.List;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.GetAllUsers;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;

public interface IUserService {

	User createUser(UsersDto usersDto);
	String upadtePassword(UserForgetPasswordDto usersDto);
	List<GetAllUsers> getall();
}
