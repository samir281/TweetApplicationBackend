package com.tweetapp.tweet.payloads;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommentDto {
	private String reply;

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
