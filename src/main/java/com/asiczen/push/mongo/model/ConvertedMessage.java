package com.asiczen.push.mongo.model;

import com.asiczen.push.mongo.dto.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class ConvertedMessage extends Vehicle {

	private boolean current;
	private String dateTimestamp;
	private Double lng;
	private Double lat;
}
