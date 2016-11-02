package com.shawn.server.core.mongodb;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;

public class MongodbGeneratorDao {

	protected MongoTemplate mongoTemplate;

	@Resource(name = "mongoTemplate")
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
