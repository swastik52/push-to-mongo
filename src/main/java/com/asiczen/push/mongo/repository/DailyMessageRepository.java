package com.asiczen.push.mongo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.asiczen.push.mongo.model.MySqlDailyMessage;

@Repository
public interface DailyMessageRepository extends CrudRepository<MySqlDailyMessage, String> {
	
	public Optional<MySqlDailyMessage> findByVehicleNumberAndDateTimestamp(String vehicleNumber,LocalDateTime dateTimestamp );

}
