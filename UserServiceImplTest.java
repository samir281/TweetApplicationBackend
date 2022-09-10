package com.tweetapp.tweet.serviceimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepo userRepo;
	
	@Mock
	TweetRepo tweetRepo;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	@Mock
	PasswordEncoder passwordEncoder;
	
	@Test
	public void createUserTest()
	{
		UsersDto userDto=new UsersDto();
		userDto.setFirstname("test");
		userDto.setId(1);
		userDto.setLastName("test");
		userDto.setMiddlename("test");
		userDto.setPassword("12345");
		userDto.setPhoneNumber("0987654321");
		userDto.setUsername("test@test.com");
		when(userRepo.findByusername(userDto.getUsername())).thenReturn(null);
		when(passwordEncoder.encode(userDto.getPassword())).thenReturn("test");
		User user=new User();
		when(userRepo.save(Mockito.any())).thenReturn(user);
		Assertions.assertNotNull(userServiceImpl.createUser(userDto));
	}
	
	@Test
	public void createUserTest2()
	{
		UsersDto userDto=new UsersDto();
		userDto.setFirstname("test");
		userDto.setId(1);
		userDto.setLastName("test");
		userDto.setMiddlename("test");
		userDto.setPassword("12345");
		userDto.setPhoneNumber("0987654321");
		userDto.setUsername("test@test.com");
		User user=new User();
		when(userRepo.findByusername(userDto.getUsername())).thenReturn(user);
		when(passwordEncoder.encode(userDto.getPassword())).thenReturn("test");
		Assertions.assertNull(userServiceImpl.createUser(userDto));
	}
	@Test
	public void createUserTest3()
	{
		UsersDto userDto=new UsersDto();
		userDto.setFirstname("test");
		userDto.setId(1);
		userDto.setLastName("test");
		userDto.setMiddlename("test");
		userDto.setPassword("12345");
		userDto.setPhoneNumber("0987654321");
		userDto.setUsername("test@test.com");
		when(passwordEncoder.encode(userDto.getPassword())).thenThrow(new RuntimeException("Message"));
		Assertions.assertNull(userServiceImpl.createUser(userDto));
	}
	
	@Test
	public void upadtePasswordTest()
	{
		UserForgetPasswordDto forgetPasswordDto=new UserForgetPasswordDto();
		forgetPasswordDto.setNewpassword("test");
		forgetPasswordDto.setUsername("test@test.com");
		forgetPasswordDto.setPhonenumber("0987654321");
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		
		when(userRepo.findByusername(forgetPasswordDto.getUsername())).thenReturn(null);
		Assertions.assertNotNull(userServiceImpl.upadtePassword(forgetPasswordDto));
	}
	@Test
	public void upadtePasswordTest2()
	{
		UserForgetPasswordDto forgetPasswordDto=new UserForgetPasswordDto();
		forgetPasswordDto.setNewpassword("test");
		forgetPasswordDto.setUsername("test@test.com");
		forgetPasswordDto.setPhonenumber("0987654321");
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		
		when(userRepo.findByusername(forgetPasswordDto.getUsername())).thenReturn(user);
		when(userRepo.updatePassword(forgetPasswordDto.getUsername(),"test")).thenReturn(1);
		when(passwordEncoder.encode(forgetPasswordDto.getNewpassword())).thenReturn("test");
		Assertions.assertNotNull(userServiceImpl.upadtePassword(forgetPasswordDto));
	}
	@Test
	public void upadtePasswordTest3()
	{
		UserForgetPasswordDto forgetPasswordDto=new UserForgetPasswordDto();
		forgetPasswordDto.setNewpassword("test");
		forgetPasswordDto.setUsername("test@test.com");
		forgetPasswordDto.setPhonenumber("0987654321");
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		
		when(userRepo.findByusername(forgetPasswordDto.getUsername())).thenReturn(user);
		when(userRepo.updatePassword(forgetPasswordDto.getUsername(),"test")).thenReturn(0);
		when(passwordEncoder.encode(forgetPasswordDto.getNewpassword())).thenReturn("test");
		Assertions.assertNotNull(userServiceImpl.upadtePassword(forgetPasswordDto));
	}
	@Test
	public void upadtePasswordTest4()
	{
		UserForgetPasswordDto forgetPasswordDto=new UserForgetPasswordDto();
		forgetPasswordDto.setNewpassword("test");
		forgetPasswordDto.setUsername("test@test.com");
		forgetPasswordDto.setPhonenumber("098765432");
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		
		when(userRepo.findByusername(forgetPasswordDto.getUsername())).thenReturn(user);
		//when(userRepo.updatePassword(forgetPasswordDto.getUsername(),"test")).thenReturn(0);
		//when(passwordEncoder.encode(forgetPasswordDto.getNewpassword())).thenReturn("test");
		Assertions.assertNotNull(userServiceImpl.upadtePassword(forgetPasswordDto));
	}
	
	@Test
	public void upadtePasswordTest5()
	{
		UserForgetPasswordDto forgetPasswordDto=new UserForgetPasswordDto();
		forgetPasswordDto.setNewpassword("test");
		forgetPasswordDto.setUsername("test@test.com");
		forgetPasswordDto.setPhonenumber("0987654321");
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		
		when(userRepo.findByusername(forgetPasswordDto.getUsername())).thenReturn(user);
		when(userRepo.updatePassword(forgetPasswordDto.getUsername(),"test")).thenReturn(0);
		//when(passwordEncoder.encode(forgetPasswordDto.getNewpassword())).thenReturn("test");
		Assertions.assertNotNull(userServiceImpl.upadtePassword(forgetPasswordDto));
	}
	
	@Test
	public void getallTest()
	{
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		List<User> listUser=new ArrayList<User>();
		listUser.add(user);
		when(userRepo.findAll()).thenReturn(listUser);
		Assertions.assertNotNull(userServiceImpl.getall());
	}
}
