package com.fisi.disoft.modelo.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class MongoSource {

    private static MongoSource mongoSource;
    private final MongoDatabase database;

    private MongoSource() {
        MongoClient client = new MongoClient("localhost", 27017);

        MongoCredential credential = MongoCredential.createScramSha1Credential(
                "dbadmin",
                "finalP1Vinos",
                "dbadmin".toCharArray());

        database = client.getDatabase("finalP1Vinos");

    }

    public static MongoSource getInstance() {
        if (mongoSource == null) {
            mongoSource = new MongoSource();
        }

        return mongoSource;
    }

    public MongoDatabase getConnection() {
        return database;
    }
}
