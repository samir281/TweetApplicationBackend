package com.tweetapp.tweet.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;

@RequestMapping("/api/v1.0/tweets")
@CrossOrigin()
public interface IUserController {
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody UsersDto userDto);
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLogin) throws Exception;
	@PostMapping("/updatepassword")
	public ResponseEntity<String> updatepasword(@Valid @RequestBody UserForgetPasswordDto userForgetPasswordDto);
	@GetMapping("/getallusers")
	public  ResponseEntity<?> getallusers();
}
