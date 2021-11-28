package studio.auradevelopment.note.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import studio.auradevelopment.utils.command.ACommand;

public class NoteCreateCommand extends ACommand {
    @Override
    public String getSubCommandName() {
        return "create";
    }

    @Override
    public String getSubCommandDescription() {
        return "create a note";
    }

    @Override
    public String getUsage() {
        return "/note create <player> <note>";
    }

    @Override
    public String getSubCommandPermission() {
        return "core.note.create";
    }

    @Override
    public void execute(Player player, String[] args) {

        if (args.length < 1) {
            player.sendMessage(getUsage());
        } else {
            if (args.length == 1) {
                player.sendMessage(getUsage());
            } else {
                Player target = Bukkit.getPlayerExact(args[1]);
                if (args.length == 2) {
                    player.sendMessage(getUsage() );
                } else {
                    String note = args[2];

                }
            }
        }
    }
}
