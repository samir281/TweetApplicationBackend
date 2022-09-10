package com.tweetapp.tweet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Like;
import com.tweetapp.tweet.entity.Tweet;

@Repository
@CrossOrigin
public interface LikeRepo extends JpaRepository<Like, Integer> {
	List<Like> findBytweet(Tweet tweet);
}
