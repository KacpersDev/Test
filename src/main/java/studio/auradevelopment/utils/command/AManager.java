package studio.auradevelopment.utils.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AManager implements CommandExecutor{

    private final ArrayList<ACommand> aCommands = new ArrayList<>();

    public AManager(){
    //    aCommands.add()
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                for (int i = 0; i < getCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getCommands().get(i).getSubCommandName())) {
                        if (player.hasPermission(getCommands().get(i).getSubCommandPermission())) {
                            getCommands().get(i).execute(player, args);
                        }
                     }
                 }
            }
        }

        return true;
    }

    public ArrayList<ACommand> getCommands() {
        return aCommands;
    }
}
