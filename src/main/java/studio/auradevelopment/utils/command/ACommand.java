package studio.auradevelopment.utils.command;

import org.bukkit.entity.Player;

public abstract class ACommand {

    public abstract String getSubCommandName();

    public abstract String getSubCommandDescription();

    public abstract String getUsage();

    public abstract String getSubCommandPermission();

    public abstract void execute(Player player, String args[]);
}
