package com.asiczen.push.mongo.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import com.asiczen.push.mongo.dto.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "vehiclemessagesprod")
@EqualsAndHashCode(callSuper = false)
public class MongoFormatMessage extends Vehicle {

	private GeoJsonPoint location;
	private LocalDateTime dateTimestamp;
}
