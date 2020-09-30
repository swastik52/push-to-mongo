package com.asiczen.push.mongo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "DailyMessage")
public class MySqlDailyMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String vehicleNumber;
	
	private String vehicleType;
	
	private String driverName;
	
	private String driverContact;
	
	private LocalDateTime dateTimestamp;
	
	private int fuel;
	
	private double speed;
	
	private String orgRefName;
	
	private Double lng;
	
	private Double lat;
	
	private double totalDistanceDaily;
	
	private double topSpeed;
}
