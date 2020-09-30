package com.asiczen.push.mongo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

	public String vehicleNumber;
	private String vehicleType;
	private String imeiNumber;
	private String driverName;
	private String driverContact;
	private String orgRefName;
	private int unplugged = 0;
	private int fuel = 0;
	private double speed = 0;
	private double distance = 0;
	private double totalDistanceDaily=0;
	private double topSpeed=0;
}
