package com.asiczen.push.mongo.service;

import org.springframework.stereotype.Service;

import com.asiczen.push.mongo.model.ConvertedMessage;

@Service
public interface MessagePushService {

	public void publishMessageToMongoDb(ConvertedMessage message);
}
