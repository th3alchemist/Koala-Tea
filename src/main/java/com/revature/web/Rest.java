package com.revature.web;

import org.springframework.web.client.RestTemplate;

import com.revature.model.Joke;

public class Rest {

	/*
	 * The RestTemplate class is built into Spring Web. It provides a convenient way
	 * of accessing data from third-party APIs and immediately marshalling it into
	 * a Java object. This is the proper way of handling calls to third-party APIs.
	 * 
	 * NOTE: This is how you consume REST with Spring.
	 */
	public static Joke getChuckJoke() {
		RestTemplate restTemplate = new RestTemplate();
		Joke retrievedJoke = restTemplate.getForObject("http://api.icndb.com/jokes/random", Joke.class);
		return retrievedJoke;
	}
}
