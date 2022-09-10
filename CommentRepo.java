package com.tweetapp.tweet.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Comment;
import com.tweetapp.tweet.entity.Tweet;
@Repository
@CrossOrigin
public interface CommentRepo extends JpaRepository<Comment, Integer> {
	public List<Comment>findAllBytweet(Tweet tweet);
	public List<Comment>findAllBytweet(Optional<Tweet> tweet);
	
}
