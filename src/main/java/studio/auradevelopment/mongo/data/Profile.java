package studio.auradevelopment.mongo.data;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Profile {

    private PlayerNotes playerNotes;
    private UUID uuid;
    private String playerName;

    public Profile(UUID uuid, String name){
        this.uuid = uuid;
        this.playerName = name;
        this.playerNotes = new PlayerNotes(uuid, playerName);
    }


}
