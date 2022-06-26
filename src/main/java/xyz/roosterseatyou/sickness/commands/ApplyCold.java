package xyz.roosterseatyou.sickness.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import xyz.roosterseatyou.sickness.sicknesses.Cold;

public class ApplyCold implements CommandExecutor {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Cold.COLD.infectPlayer(player);
            return true;
        }
        return false;
    }
}

