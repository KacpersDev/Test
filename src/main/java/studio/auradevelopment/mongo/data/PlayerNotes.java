package studio.auradevelopment.mongo.data;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import studio.auradevelopment.Core;
import studio.auradevelopment.mongo.MongoHandler;
import studio.auradevelopment.note.Note;

import java.util.UUID;

public class PlayerNotes {

    private final Core plugin = Core.getInstance();
    private final MongoHandler mongoHandler = new MongoHandler();

    private UUID uuid;
    private String playerName;
    private final Note note = new Note();

    public PlayerNotes(UUID uuid, String name){
        this.uuid = uuid;
        this.playerName = name;
    }

    public void resetPlayer(){
        this.note.setNoteAmount(0);
    }

    public void load(){
        Document document = mongoHandler.documentMongoCollection.find(Filters.eq("uuid", getUuid().toString())).first();
        if (document != null) {
            this.note.setNoteAmount(document.getInteger("note"));
        }
    }

    public void save(){
        Document document = new Document();
        document.put("name", getPlayerName().toLowerCase());
        document.put("realName", getPlayerName());
        document.put("uuid", getUuid().toString());
        document.put("note", this.note.getAmount());
        mongoHandler.documentMongoCollection.replaceOne(Filters.eq("uuid", getUuid().toString()), document, new UpdateOptions().upsert(true));
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Note getNote(){
        return note;
    }
}
