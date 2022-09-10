package com.tweetapp.tweet.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Comment;
import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.payloads.GetallComment;
import com.tweetapp.tweet.repo.CommentRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.ICommentService;
@Service
@CrossOrigin
public class CommentServiceImpl implements ICommentService {

	@Autowired
	public TweetRepo tweetrepo;
	@Autowired
	UserRepo userrepo;
	@Autowired
	public CommentRepo commentRepo;
	@Override
	public String replyToTweet(CommentDto commentDto, String username,int id) {
 
		Comment comment=new Comment();
		comment.setReply(commentDto.getReply());
		comment.setUserName(username);
		LocalDateTime dtm = LocalDateTime.now(); 
		comment.setDate(dtm);
		Optional<Tweet> tweet=tweetrepo.findById(id);
		if(tweet.isPresent()) {				
		comment.setTweet(tweet.get());
		}
		commentRepo.save(comment);
		return "Done";
	}
	@Override
	public List<GetallComment> getallcomment(int tweetid) {
 try {
		Optional<Tweet> tweet=tweetrepo.findById(tweetid);
		List<Comment> listComment=commentRepo.findAllBytweet(tweet);
		if(listComment.isEmpty())
		{
			throw new NoSuchElementException();
		}
		List<GetallComment> getallComment=new ArrayList<GetallComment>();
 
		for (Comment comment : listComment) {
			GetallComment temp=new GetallComment();
			temp.setDate(comment.getDate());
			temp.setId(comment.getId());
			temp.setUserName(comment.getUserName());
			temp.setReply(comment.getReply());
			getallComment.add(temp);
		}
		return getallComment;
 }
 catch(NoSuchElementException e)
	{

		throw new NoSuchElementException("No Comment Found");
	}
	}
	
	public String deleteallComment(Tweet tweet) {
		List<Comment> listComment=commentRepo.findAllBytweet(tweet);
		if(listComment.size()>0)
		{
			commentRepo.deleteAll(listComment);
			return "done";
		}
		return "Nocomment";
		
	}
}
