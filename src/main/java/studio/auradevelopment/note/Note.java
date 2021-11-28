package studio.auradevelopment.note;

import org.bukkit.entity.Player;
import studio.auradevelopment.Core;
import studio.auradevelopment.mongo.data.Profile;

public class Note {

    private int noteAmount;

    public void addNote(int amount){
        this.noteAmount = this.noteAmount + amount;
    }

    public void removeNote(int amount) {
        this.noteAmount = this.noteAmount - amount;
    }

    public Integer getAmount(){
        return this.noteAmount;
    }

    public void setNoteAmount(int amount){
        this.noteAmount = amount;
    }

    //profile.getPlayerNotes().getNote().setNoteAmount(1);
}
