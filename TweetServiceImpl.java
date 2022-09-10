
package com.tweetapp.tweet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.repo.CommentRepo;
import com.tweetapp.tweet.repo.LikeRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.ITweetService;

@Service
@CrossOrigin
public class TweetServiceImpl implements ITweetService {

	@Autowired
	TweetRepo tweetRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	LikeRepo likeRepo;
 
	@Override
	public TweetDto createTweet(TweetDto tweetDto, String username) {
		 
		User user=userRepo.findByusername(username);
		Tweet tweet=new Tweet();
		tweet.setDate(new Date());
		tweet.setDescription(tweetDto.getDiscription());
		tweet.setId(tweetDto.getId());
		tweet.setUser(user);
		Tweet tweet2=tweetRepo.save(tweet);
		TweetDto result=new TweetDto(tweet2.getId(),tweet.getDescription());
		return result;
	}

	@Override
	public ArrayList<TweetByUser> getalltweetbyuser(String username)   {
		 
			try {
				User user=userRepo.findByusername(username);
				ArrayList<TweetByUser> listofTweets=new ArrayList<TweetByUser>();
				List<Tweet> tweets=new ArrayList<Tweet>();
			tweets=tweetRepo.findByuser(user);
			if(tweets.isEmpty())
			{
				throw new NoSuchElementException();
			}
			for(Tweet i:tweets)
			{
				TweetByUser temp=new TweetByUser(i.getId(),i.getDescription(),i.getUser().getUsername(),i.getDate());
				listofTweets.add(temp);
			}
			return listofTweets;
			}
			catch(NoSuchElementException e)
			{

				throw new NoSuchElementException();
			}
	}

	@Override
	public TweetDto updateTweet(TweetDto tweetDto, int tweetid,String username) throws TweetException {
	 
		Tweet tweet=this.tweetRepo.findById(tweetid).orElseThrow(()-> new TweetException("This tweet "+tweetid+" is not persent"));
		User user=userRepo.findUserByUsername(username).orElseThrow(()-> new TweetException("This Username is not persent"));
		if(user.getUsername().equals(tweet.getUser().getUsername())) 
		{
		tweet.setDescription(tweetDto.getDiscription());
		TweetDto tweetDto2=new TweetDto();
		try {
		this.tweetRepo.save(tweet);
		tweetDto2.setDiscription(tweet.getDescription());
		tweetDto2.setId(tweet.getId());
		return tweetDto2;
		}
		catch(Exception e)
		{
			return tweetDto2;
		}
		}
		else
		{
 
			throw new TweetException("Enter valid username and tweet id");
		}
	}


	@Override
	public List<TweetByUser> getalltweets() {
	 
		List<Tweet> tweetList=tweetRepo.findAll();
		List<TweetByUser> list=new ArrayList<TweetByUser>();
		for (Tweet tweet : tweetList) {
			TweetByUser temp=new TweetByUser();
			temp.setId(tweet.getId());
			temp.setDate(tweet.getDate());
			temp.setDescip(tweet.getDescription());
			temp.setUsername(tweet.getUser().getUsername());
			list.add(temp);
		}
		return list;
	}

	@Autowired
	CommentServiceImpl commentServiceImpl;
	@Autowired 
	LikeServiceImpl impl;
@Override
public String deletPost(int tweetid, String Username) throws TweetException {
 
	
	Optional<Tweet> tweet=tweetRepo.findById(tweetid);
	if(tweet.isPresent()) {
	commentServiceImpl.deleteallComment(tweet.get());
	impl.deleteallLikes(tweet.get());
	tweetRepo.delete(tweet.get());
	return "Done";}
	else {
		return "Not Done";
	}
}

}
