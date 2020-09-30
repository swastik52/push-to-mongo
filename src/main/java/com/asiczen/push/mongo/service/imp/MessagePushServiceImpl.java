package com.asiczen.push.mongo.service.imp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import com.asiczen.push.mongo.model.ConvertedMessage;
import com.asiczen.push.mongo.model.MongoFormatMessage;
import com.asiczen.push.mongo.repository.MongoFormatMessageRepository;
import com.asiczen.push.mongo.service.MessagePushService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessagePushServiceImpl implements MessagePushService {

	@Autowired
	MongoFormatMessageRepository mongoRepo;

	@Override
	public void publishMessageToMongoDb(ConvertedMessage message) {

		MongoFormatMessage formatMessage = new MongoFormatMessage();
		BeanUtils.copyProperties(message, formatMessage);
		formatMessage.setLocation(new GeoJsonPoint(message.getLng(), message.getLat()));

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(message.getDateTimestamp(), formatter);
			formatMessage.setDateTimestamp(dateTime);
			log.trace("Coveted date and time is {} ", dateTime);
			log.trace("Recived date and time is {} ", message.getDateTimestamp());

		} catch (Exception ep) {
			log.error("Failed to convert the date time stamp, so setting it to current time {} ", ep.getMessage());
			formatMessage.setDateTimestamp(LocalDateTime.now());

		}

		mongoRepo.save(formatMessage);
	}

}
