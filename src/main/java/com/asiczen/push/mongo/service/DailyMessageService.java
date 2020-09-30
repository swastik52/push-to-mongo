package com.asiczen.push.mongo.service;

import org.springframework.stereotype.Service;
import com.asiczen.push.mongo.model.ConvertedMessage;

@Service
public interface DailyMessageService {

	public void savetodb(ConvertedMessage message);
	
}
