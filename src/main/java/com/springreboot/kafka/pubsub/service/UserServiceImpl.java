package com.springreboot.kafka.pubsub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreboot.kafka.pubsub.event.publisher.EventPublisher;
import com.springreboot.kafka.pubsub.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	EventPublisher publisher;

	@Override
	public void publishMessage(User user) {
		publisher.publish(user);
	}

}
