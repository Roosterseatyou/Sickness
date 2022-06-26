package xyz.roosterseatyou.sickness;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.commands.ApplyCold;
import xyz.roosterseatyou.sickness.commands.ApplyFoodPoisoning;
import xyz.roosterseatyou.sickness.sicknesses.Cold;
import xyz.roosterseatyou.sickness.sicknesses.FoodPoisoning;
import xyz.roosterseatyou.sickness.sicknesses.symptoms.Sneezing;

import java.util.ArrayList;

public final class Sickness extends JavaPlugin {
    private static Plugin instance;
    private static ComponentLogger logger;
    public static ArrayList<Illness> illnesses = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        logger = getComponentLogger();
        FoodPoisoning.FOOD_POISONING.register();
        Cold.COLD.register();
        getCommand("applyfoodpoisoning").setExecutor(new ApplyFoodPoisoning());
        getCommand("applycold").setExecutor(new ApplyCold());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return instance;
    }

    public static ComponentLogger logger() {
        return logger;
    }
}
