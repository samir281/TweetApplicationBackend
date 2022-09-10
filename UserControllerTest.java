package com.tweetapp.tweet.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.authentication.AuthenticationManager;

import com.tweetapp.tweet.config.CustomUserDetailsService;
import com.tweetapp.tweet.config.JwtUtil;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.GetAllUsers;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.service.IUserService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserControllerTest {

	@Mock 
	private IUserService iUserService;
	
	@Mock
	private AuthenticationManager auth;
	
	@Mock 
	private JwtUtil jwtutil;
	
	@Mock 
	private CustomUserDetailsService cust;
	  
	@InjectMocks
	  UserController userController;
	  
	  @Test 
	  public void signUpTest1() { 
		  UsersDto usersDto=new UsersDto();
		  System.out.println(iUserService);
	  usersDto.setFirstname("test"); usersDto.setLastName("test");
	  usersDto.setMiddlename("test"); usersDto.setPassword("test");
	  usersDto.setPhoneNumber("test"); usersDto.setUsername("test"); 
	  User user=new User(); 
	  user.setFirstname("sam");
	  Mockito.when(iUserService.createUser(Mockito.any(UsersDto.class))).thenReturn(user); 
	  userController.signUp(usersDto); 
	 }
	  @Test 
	  public void signUpTest2() { 
		  UsersDto usersDto=new UsersDto();
		  System.out.println(iUserService);
	  //IUserService iUserService=Mockito.mock(IUserService.class);
	  usersDto.setFirstname("test"); usersDto.setLastName("test");
	  usersDto.setMiddlename("test"); usersDto.setPassword("test");
	  usersDto.setPhoneNumber("test"); usersDto.setUsername("test"); 
	  User user=null;
	  Mockito.when(iUserService.createUser(Mockito.any(UsersDto.class))).thenReturn(user); 
	  userController.signUp(usersDto); 
	 }
	  
	  @Test
	  public void getallUsersTest()
	  {
		  List<GetAllUsers> getallusers=new ArrayList<GetAllUsers>();
		  when(iUserService.getall()).thenReturn(getallusers);
		  userController.getallusers();
	  }
	  @Test
	  public void updatepaswordTest()
	  {
		  UserForgetPasswordDto userForgetPasswordDto=new UserForgetPasswordDto();
		  when(iUserService.upadtePassword(userForgetPasswordDto)).thenReturn("test");
		  userController.updatepasword(userForgetPasswordDto);
	  }
	  @Test
	  public void updatepaswordTest1()
	  {
		  UserForgetPasswordDto userForgetPasswordDto=new UserForgetPasswordDto();
		  when(iUserService.upadtePassword(userForgetPasswordDto)).thenReturn("OK");
		  userController.updatepasword(userForgetPasswordDto);
	  }
}
