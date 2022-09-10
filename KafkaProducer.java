//package com.tweetapp.tweet.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//import com.tweetapp.tweet.payloads.TweetDelete;
//import com.tweetapp.tweet.payloads.UsersDto;
//
//@Service
//public class KafkaProducer {
//
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
//	
//	private KafkaTemplate<String, UsersDto> kafkaTemplate;
//	
//	public KafkaProducer(KafkaTemplate<String, UsersDto> kafkaTemplate) {
//		this.kafkaTemplate = kafkaTemplate;
//	}
//
//	
//	
////	public void sendMessage(UsersDto user) {
////		LOGGER.info(String.format("Message sent %s", user.toString()));
////		Message<UsersDto> message = MessageBuilder
////				.withPayload(user)
////				.setHeader(KafkaHeaders.TOPIC, "deleteTweetByUser")
////				.build();
////		kafkaTemplate.send(message);
////		
////}
//	public void sendMessage(TweetDelete user) {
//		LOGGER.info(String.format("Message sent %s", user.toString()));
//		Message<TweetDelete> message = MessageBuilder
//				.withPayload(user)
//				.setHeader(KafkaHeaders.TOPIC, "deleteTweetByUser")
//				.build();
//		kafkaTemplate.send(message);
//		
//}
//}
