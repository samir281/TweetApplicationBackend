package com.tweetapp.tweet.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.config.CustomUserDetailsService;
import com.tweetapp.tweet.config.JwtUtil;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.GetAllUsers;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.service.IUserService;


@RestController
@CrossOrigin
public class UserController implements IUserController {

	@Autowired
	public IUserService iUserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	private static final Logger Log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	@Override
	public ResponseEntity<String> signUp(@Valid @RequestBody UsersDto userDto) {
 
		Log.info("in the signup method");
		User users=iUserService.createUser(userDto);
		if(users!=null) {
 
			String response1="created";
		return new ResponseEntity<String>(response1, HttpStatus.OK);
		}
		return new ResponseEntity<>("Some thing got wrong", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> login(@Valid UserLogin userLogin) throws Exception{
		try {
			org.springframework.security.core.Authentication authObject = null;
			authObject=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
			//SecurityContextHolder.getContext().setAuthentication(authObject);
		} catch (BadCredentialsException e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
 
		}
		String jwt=jwtUtil.generateToken(customUserDetailsService.loadUserByUsername(userLogin.getUsername()));
		return ResponseEntity.ok(jwt);
	}

	@Override
	public ResponseEntity<?> getallusers() {
		List<GetAllUsers> getAllUsersList=iUserService.getall();
		return new ResponseEntity<>(getAllUsersList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updatepasword(@Valid UserForgetPasswordDto userForgetPasswordDto) {
		String response=iUserService.upadtePassword(userForgetPasswordDto);
		if(response.equals("OK"))
		return new ResponseEntity<String>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
