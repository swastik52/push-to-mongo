package com.asiczen.push.mongo.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiczen.push.mongo.model.ConvertedMessage;
import com.asiczen.push.mongo.service.DailyMessageService;
import com.asiczen.push.mongo.service.MessagePushService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageConsumer {

	@Autowired
	MessagePushService service;
	
	@Autowired
	DailyMessageService dailyService;


	@RabbitListener(queues = "covertedMessages")
	public void onMessageReceipt(ConvertedMessage message) {
		try {

			service.publishMessageToMongoDb(message);
		} catch (Exception ep) {

			log.error("Error while pusing messages to Mongo Db");
		}
	}
	
	@RabbitListener(queues = "dailyVehicleResetData")
	public void dailyMessage(ConvertedMessage message) {
		
		//check with previous message and store in database
		try {
			dailyService.savetodb(message);
		} catch (Exception ep) {

			log.error("Error while pusing messages to  Db");
		}
		
	}

}
