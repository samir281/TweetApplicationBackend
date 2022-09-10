package com.tweetapp.tweet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.payloads.GetAlllikes;
import com.tweetapp.tweet.service.ILikeService;

@RestController
@CrossOrigin
public class LikeController implements ILikeController {
	@Autowired
	private ILikeService iLikeService;

	@Override
	public ResponseEntity<?> updateLike(String username, int tweetid) {
		// TODO Auto-generated method stub
		iLikeService.addlike(tweetid, username);
		return new ResponseEntity<String>("done",HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> getallLikes(String username, int tweetid) {
		// TODO Auto-generated method stub
		GetAlllikes getAlllikes=iLikeService.getallLikes(tweetid, username);
		return new ResponseEntity<GetAlllikes>(getAlllikes,HttpStatus.OK);
	}

}
