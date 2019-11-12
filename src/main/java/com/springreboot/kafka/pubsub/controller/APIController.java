package com.springreboot.kafka.pubsub.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreboot.kafka.pubsub.model.User;
import com.springreboot.kafka.pubsub.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(path = "/springreboot/pubsub")
public class APIController {

	@Autowired
	UserService us;

	// Don't worry about this being GET. This is just for demo
	@GetMapping(path = "/v1/users/{name}/{info}")
	public void publishMessage(@PathVariable String name, @PathVariable String info) {
		us.publishMessage(new User(ThreadLocalRandom.current().nextLong(1,1000)+"", name, info));
	}
}
