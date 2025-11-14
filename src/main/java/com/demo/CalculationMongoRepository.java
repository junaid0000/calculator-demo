package com.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CalculationMongoRepository {
	private MongoCollection<Document> calculations;

	public CalculationMongoRepository(MongoClient mongoClient) {
		MongoDatabase database = mongoClient.getDatabase("calculator");
		this.calculations = database.getCollection("calculations");
	}

	public void saveCalculation(String expression, String result) {
		Document doc = new Document("expression", expression).append("result", result).append("timestamp",
				new java.util.Date());
		calculations.insertOne(doc);
	}
}