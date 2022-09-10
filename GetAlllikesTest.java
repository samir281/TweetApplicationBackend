package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetAlllikesTest {
	
	@Test
	public void allGetterSetterTest()
	{
		GetAlllikes getAlllikes=new GetAlllikes();
		getAlllikes.setCount(1);
		getAlllikes.setUserLiked(true);
		
		Assertions.assertEquals(getAlllikes.getCount(),1);
		Assertions.assertTrue(getAlllikes.isUserLiked());
	}

}
