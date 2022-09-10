//package com.tweetapp.tweet.Controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tweetapp.tweet.kafka.KafkaProducer;
//import com.tweetapp.tweet.payloads.TweetDelete;
//import com.tweetapp.tweet.payloads.UsersDto;
//
//@RestController
//@RequestMapping("/api/v1.0/tweets")
////@CrossOrigin(origins = "http://localhost:3000")
//public class MessageController {
//
//	private KafkaProducer kafkaProducer;
//
//	public MessageController(KafkaProducer kafkaProducer) {
//		this.kafkaProducer = kafkaProducer;
//	}
//	
////	@PostMapping("/publish")
////	public ResponseEntity<String> publish(@RequestBody UsersDto user ){
////		kafkaProducer.sendMessage(user);
////		return ResponseEntity.ok("Message sent to the topic");
////	}
//	@PostMapping("/publish")
//	public ResponseEntity<String> publish(@RequestBody TweetDelete user ){
//		kafkaProducer.sendMessage(user);
//		return ResponseEntity.ok("Message sent to the topic");
//	}
//}
