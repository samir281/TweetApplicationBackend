package com.tweetapp.tweet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.GetAllUsers;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.IUserService;
@Service
@CrossOrigin
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User createUser(UsersDto usersDto) 
	{
		try {
		User user= new User(usersDto.getId(),usersDto.getFirstname(),usersDto.getMiddlename(),usersDto.getLastName(),usersDto.getPhoneNumber(),
				usersDto.getUsername(),
				passwordEncoder.encode(usersDto.getPassword()));
		if(userRepo.findByusername(user.getUsername())==null) 
		{
		return userRepo.save(user);
		}
		else
			return null;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	@Override
	public String upadtePassword(UserForgetPasswordDto usersDto) {
		try {
		User user=userRepo.findByusername(usersDto.getUsername());
		if(user==null)
		{
			return "Wrong Username";
		}
		else if(user.getPhoneNumber().equalsIgnoreCase(usersDto.getPhonenumber()))
		{
			int result=userRepo.updatePassword(usersDto.getUsername(),passwordEncoder.encode(usersDto.getNewpassword()));
			if(result==1)
			{
				return "OK";
			}
			else
			{
				return "Something went wrong please try again1";
			}
		}
		else
		{
			return "Entered phone No. is not Linked with this Account";
		}
		}
		catch(Exception e) {
		return "Something went wrong please try again";
		}
	}

	@Override
	public List<GetAllUsers> getall() {
		List<User> listUser=userRepo.findAll();
		List<GetAllUsers> result=new ArrayList<GetAllUsers>();
		for (User user : listUser) {
			GetAllUsers temp=new GetAllUsers();
			temp.setFirstname(user.getFirstname());
			temp.setLastname(user.getLastName());
			temp.setId(user.getId());
			temp.setUsername(user.getUsername());
			result.add(temp);
		}
		return result;
	}

}
