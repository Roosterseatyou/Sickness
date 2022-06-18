package xyz.roosterseatyou.sickness;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sickness extends JavaPlugin {
    private static Plugin instance;
    private static ComponentLogger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        logger = getComponentLogger();
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
