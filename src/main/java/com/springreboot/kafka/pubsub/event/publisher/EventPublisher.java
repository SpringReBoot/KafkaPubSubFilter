package com.springreboot.kafka.pubsub.event.publisher;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import com.springreboot.kafka.pubsub.model.User;

@Component
public class EventPublisher {

	@Autowired
	KafkaTemplate<String, User> template;
	
	@Value(value = "${springreboot.pubsub.kafka.topic}")
	String topicName;
	
	public void publish(User user) {
		ProducerRecord<String, User> record = new ProducerRecord<String, User>(topicName, user.getId(), user);
		record.headers().add("header1", "test".getBytes());
		ListenableFuture<SendResult<String, User>> future = this.template.send(record);
		 future.addCallback(new SuccessCallback<SendResult<String, User>>() {
			
			@Override
			public void onSuccess(SendResult<String, User> result) {
				System.out.println(result); 
			}
		}, new FailureCallback() {
			
			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();
			}
		});
	}
}
