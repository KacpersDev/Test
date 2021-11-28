package studio.auradevelopment.mongo.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import studio.auradevelopment.Core;

public class LoadData implements Listener {

    //profile.getPlayerNotes().getNote().setNoteAmount(1);

    private final Core core;

    public LoadData(Core core){
        this.core = core;
    }

    @EventHandler
    public void loadData(PlayerJoinEvent event){

        Player player = event.getPlayer();
        core.getProfileManager().handleProfileCreation(player.getUniqueId(), player.getName());
        Profile profile = core.getProfileManager().getProfile(player.getUniqueId());
        profile.getPlayerNotes().load();
        Bukkit.getConsoleSender().sendMessage(profile.getPlayerName() + " has been loaded.");

    }
}
