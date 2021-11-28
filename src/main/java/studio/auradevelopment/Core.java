package studio.auradevelopment;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import studio.auradevelopment.mongo.MongoCatch;
import studio.auradevelopment.mongo.MongoHandler;
import studio.auradevelopment.mongo.data.LoadData;
import studio.auradevelopment.mongo.manager.ProfileManager;
import studio.auradevelopment.utils.command.AManager;

import java.io.File;
import java.io.IOException;

public final class Core extends JavaPlugin {

    private MongoHandler mongoHandler;
    private MongoCatch mongoCatch;
    private ProfileManager profileManager;

    public File c;
    public FileConfiguration cc;
    private static Core instance;

    @Override
    public void onEnable() {
        instance = this;
        config();
        storage();
        profileManager = new ProfileManager(this);
        listeners();
        commands();
    }

    public FileConfiguration getConfig() {
        return cc;
    }

    public static Core getInstance() {
        return instance;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    @Override
    public void onDisable() {
    }

    private void listeners(){
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new LoadData(this), this);
    }

    private void commands(){

        getCommand("note").setExecutor(new AManager());
    }

    private void config(){

        c = new File(getDataFolder(), "config.yml");

        if (!(c.exists())) {
            c.getParentFile().mkdir();
            saveResource("config.yml", false);
        }

        cc = new YamlConfiguration();
        try {
            cc.load(c);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void storage(){

        if (getConfig().getString("storage").equalsIgnoreCase("mongo")) {
            this.mongoCatch = new MongoCatch();
            this.mongoHandler = new MongoHandler();
            Bukkit.getConsoleSender().sendMessage("THIS SERVER IS USING MONGO");
        } else if (getConfig().getString("storage").equalsIgnoreCase("flatfile")) {
            Bukkit.getConsoleSender().sendMessage("THIS SERVER IS USING FLATFILE");
        }
    }
}
