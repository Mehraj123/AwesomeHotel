package com.hotelcontroller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.ah.MongoWithBootApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=MongoWithBootApplication.class)
//@WebMvcTest(controllers = ABCControllerTest.class, secure = false)
public class ABCControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testABC(){
		String res = restTemplate.getForObject("/abc", String.class);
		assertThat(res).isEqualTo("Hi");
	}
	
	

}
