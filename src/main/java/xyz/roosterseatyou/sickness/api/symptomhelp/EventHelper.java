package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;

public class EventHelper<T extends Event> implements Listener {
    private final Class<? extends Event> eventClass;
    private final Consumer<T> handler;
    private final Plugin plugin;

    public EventHelper(Plugin plugin, Class<? extends Event> eventClass, Consumer<T> handler) {
        this.plugin = plugin;
        this.eventClass = eventClass;
        this.handler = handler;
    }

    @EventHandler
    public void onEvent(T event) {
        if (eventClass.isInstance(event)) {
            handler.accept(event);
        }
    }

    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void unregister() {
        HandlerList.unregisterAll(this);
    }
}
