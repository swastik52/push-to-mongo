package com.asiczen.push.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.asiczen.push.mongo.model.MongoFormatMessage;

public interface MongoFormatMessageRepository extends MongoRepository<MongoFormatMessage, String> {

}
