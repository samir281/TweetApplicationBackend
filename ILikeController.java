package com.tweetapp.tweet.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1.0/tweets")
@CrossOrigin()
public interface ILikeController {
	
	@PutMapping("{username}/like/{tweetid}")
	public ResponseEntity<?> updateLike(@PathVariable String username,@PathVariable int tweetid);
	@GetMapping("{username}/getallLike/{tweetid}")
	public ResponseEntity<?> getallLikes(@PathVariable String username,@PathVariable int tweetid);
}
