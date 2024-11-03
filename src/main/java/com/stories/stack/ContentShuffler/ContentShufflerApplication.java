package com.stories.stack.ContentShuffler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ContentShufflerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentShufflerApplication.class, args);
	}

}
