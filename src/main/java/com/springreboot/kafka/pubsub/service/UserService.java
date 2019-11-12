package com.springreboot.kafka.pubsub.service;

import com.springreboot.kafka.pubsub.model.User;

public interface UserService {

	public void publishMessage(User user);
}
