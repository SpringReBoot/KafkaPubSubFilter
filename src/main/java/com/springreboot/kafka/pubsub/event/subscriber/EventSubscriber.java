package com.springreboot.kafka.pubsub.event.subscriber;

import java.nio.charset.StandardCharsets;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.springreboot.kafka.pubsub.model.User;

@Component
public class EventSubscriber {

	@KafkaListener(id = "${springreboot.pubsub.kafka.consumer.group.id", topics = "${springreboot.pubsub.kafka.topic}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(ConsumerRecord<String, User> record) {
		record.headers().forEach( header -> {
			String value = new String(header.value(), StandardCharsets.UTF_8); 
			System.out.println("Key :"+ header.key() +", Value :"+value);
		});
		System.out.println(record);
		System.out.println(record.value());
	}

}
