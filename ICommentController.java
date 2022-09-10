package com.tweetapp.tweet.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweetapp.tweet.payloads.CommentDto;
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin
public interface ICommentController {
	@PostMapping("/{username}/reply/{id}")
	public ResponseEntity<String> replytoTweet(@PathVariable String username,@PathVariable int id,@Valid @RequestBody CommentDto commentDto);
	@GetMapping("/getallreply/{id}")
	public ResponseEntity<?> getallreply(@PathVariable int id);
}
