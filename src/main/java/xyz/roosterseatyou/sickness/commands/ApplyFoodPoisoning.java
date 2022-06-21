package xyz.roosterseatyou.sickness.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.sickness.sicknesses.FoodPoisoning;

public class ApplyFoodPoisoning implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            FoodPoisoning.FOOD_POISONING.infectPlayer(player);
        }
        return false;
    }
}
