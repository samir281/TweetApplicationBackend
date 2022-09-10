//package com.tweetapp.tweet.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.tweetapp.tweet.exception.TweetException;
//import com.tweetapp.tweet.payloads.TweetDelete;
//import com.tweetapp.tweet.payloads.UsersDto;
//import com.tweetapp.tweet.service.ITweetService;
//import com.tweetapp.tweet.service.IUserService;
//
//@Service
//public class KafkaConsumer {
//	
//	@Autowired
//	ITweetService tweetService;
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
//
////	@KafkaListener(topics = "deleteTweetByUser", groupId = "myGroup")
////	public void consume(UsersDto user) {
////		
////		LOGGER.info(String.format("Message received %s", user.toString()));
////		userService.createUser(user);
////		/*
////		 * try { String response = tweetService.deletPost(tweet.getTweetId(),
////		 * tweet.getUsername()); LOGGER.info(String.format("Post deleted %s",
////		 * response)); } catch (TweetException e) { // TODO Auto-generated catch block
////		 * e.printStackTrace(); }
////		 */
////	}
//	@KafkaListener(topics = "deleteTweetByUser", groupId = "myGroup")
//	public void consume(TweetDelete user) {
//		
//		LOGGER.info(String.format("Message received %s", user.toString()));
////		userService.createUser(user);
//		try {
//			String res=tweetService.deletPost(user.getTweetId(), user.getUsername());
//		} catch (TweetException e) {
//			// TODO Auto-generated catch block
//			System.out.println("EXception is -----------> "+e);
//			e.printStackTrace();
//		}
//		/*
//		 * try { String response = tweetService.deletPost(tweet.getTweetId(),
//		 * tweet.getUsername()); LOGGER.info(String.format("Post deleted %s",
//		 * response)); } catch (TweetException e) { // TODO Auto-generated catch block
//		 * e.printStackTrace(); }
//		 */
//	}
//}
