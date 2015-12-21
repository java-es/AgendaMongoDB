package com.wordpress.javaes.repositorio;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.wordpress.javaes.util.Util;
import java.io.IOException;
import java.util.Properties;
import org.bson.Document;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class ConexaoDB {

    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> mongoCollection;

    public ConexaoDB() {
        try {
            Properties properties = Util.getProp();
            String host = properties.getProperty("prop.server.host");
            String database = properties.getProperty("prop.server.database");
            String collection = properties.getProperty("prop.server.collection");

            MongoClientURI uri = new MongoClientURI(host,
                    MongoClientOptions.builder().cursorFinalizerEnabled(false));

            this.mongoClient = new MongoClient(uri);

            this.db = mongoClient.getDatabase(database);
            this.mongoCollection = db.getCollection(collection);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void fecharConexao() {
        this.mongoClient.close();
    }

    public MongoCollection<Document> getMongoCollection() {
        return mongoCollection;
    }
}
