package com.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.*;

public class CalculationMongoRepositoryIT {

	@Test
	public void testSaveCalculationToMongoDB() {
		// Start MongoDB in Docker using Testcontainers
		try (MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"))) {
			mongoDBContainer.start();

			// Connect to real MongoDB
			String connectionString = mongoDBContainer.getConnectionString();
			try (MongoClient mongoClient = MongoClients.create(connectionString)) {

				// Test the repository with real database
				CalculationMongoRepository repository = new CalculationMongoRepository(mongoClient);
				repository.saveCalculation("5 + 3", "8");

				// Verify data was saved in real MongoDB
				MongoDatabase database = mongoClient.getDatabase("calculator");
				MongoCollection<Document> calculations = database.getCollection("calculations");

				long count = calculations.countDocuments();
				assertEquals(1, count);
			}
		}
	}
}