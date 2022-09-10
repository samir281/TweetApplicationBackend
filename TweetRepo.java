package com.tweetapp.tweet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;

@Repository
@CrossOrigin
public interface TweetRepo extends JpaRepository<Tweet, Integer> {
	
	List<Tweet> findByuser(User user);
 
}
