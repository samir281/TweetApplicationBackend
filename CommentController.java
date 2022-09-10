package com.tweetapp.tweet.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.payloads.GetallComment;
import com.tweetapp.tweet.service.ICommentService;
@RestController
@CrossOrigin
public class CommentController implements ICommentController {

	@Autowired
	ICommentService commentService;
	@Override
	public ResponseEntity<String> replytoTweet(String username, int id, @Valid CommentDto commentDto) {
		String res=commentService.replyToTweet(commentDto, username, id);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> getallreply(int id) {
 
		List<GetallComment> listcomment=commentService.getallcomment(id);
			return new ResponseEntity<>(listcomment,HttpStatus.OK);
		}

}
