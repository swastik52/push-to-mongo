package com.asiczen.push.mongo.service.imp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiczen.push.mongo.model.ConvertedMessage;
import com.asiczen.push.mongo.model.MySqlDailyMessage;
import com.asiczen.push.mongo.repository.DailyMessageRepository;
import com.asiczen.push.mongo.service.DailyMessageService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DailyMessageServiceImpl implements DailyMessageService {

	@Autowired
	private DailyMessageRepository messageRepo;

	@Override
	public void savetodb(ConvertedMessage message) {

		MySqlDailyMessage formatMessage = new MySqlDailyMessage();

		// set in db object
//		formatMessage.setVehicleNumber(message.getVehicleNumber());
//		formatMessage.setLng(message.getLng());
//		formatMessage.setLat(message.getLat());
//
//		formatMessage.setDriverName(message.getDriverName());
//		formatMessage.setDriverContact(message.getDriverContact());
//
//		formatMessage.setFuel(message.getFuel());
//		formatMessage.setSpeed(message.getSpeed());

		BeanUtils.copyProperties(message, formatMessage);
		LocalDateTime dateTime=null;
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		dateTime = LocalDateTime.parse(message.getDateTimestamp(), formatter);
		formatMessage.setDateTimestamp(dateTime);
		} catch (Exception ep) {
			log.error("Error while converting the date format");
			log.error(message.toString());
			formatMessage.setDateTimestamp(LocalDateTime.now());
		}
		// check vehicle no and date is available or not
		try {
			Optional<MySqlDailyMessage> dailyMessage = messageRepo.findByVehicleNumberAndDateTimestamp(message.getVehicleNumber(), dateTime);
			log.trace("database=" + dailyMessage);
			if (dailyMessage.isEmpty()) {
				messageRepo.save(formatMessage);
			} else {
				log.trace("This is an old message {} ", dailyMessage.toString());
			}
		}catch(Exception e) {
			log.trace("Data format is not valid unable to Store in database.");
		}

	}
}
