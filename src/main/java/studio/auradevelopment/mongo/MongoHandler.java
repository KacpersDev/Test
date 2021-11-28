package studio.auradevelopment.mongo;


import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.configuration.file.FileConfiguration;
import studio.auradevelopment.Core;

import java.util.Collections;

public class MongoHandler {

    public MongoClient mongoClient;
    public MongoDatabase mongoDatabase;
    public MongoCollection<Document> documentMongoCollection;

    public MongoHandler(){
        this.load();
    }

    public void load(){
        FileConfiguration config = Core.getInstance().getConfig();

        MongoCredential mongoCredential =
                MongoCredential.createCredential(
                        config.getString("mongo.auth.user"), config.getString("mongo.auth.database"), config.getString("mongo.auth.password").toCharArray()
                );
        mongoClient = new MongoClient(new ServerAddress(
                config.getString("mongo.host"), config.getInt("mongo.port")
        ), Collections.singletonList(mongoCredential));

        mongoDatabase = mongoClient.getDatabase(config.getString("mongo.auth.database"));
        documentMongoCollection = mongoDatabase.getCollection("Server");
    }
}
