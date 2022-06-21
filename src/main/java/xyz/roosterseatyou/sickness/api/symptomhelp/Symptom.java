package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Symptom<T extends Event> implements Listener {
    private Class<T> eventClass;
    private Consumer<T> handler;
    private Illness illness;
    private ArrayList<EventHelper> eventHelpers = new ArrayList<>();

    public Symptom(Class<T> eventClass, Consumer<T> handler, Illness illness) {
        this.eventClass = eventClass;
        this.handler = handler;
        this.illness = illness;
    }

    public Class<T> getEventClass() {
        return eventClass;
    }

    public Consumer<T> getHandler() {
        return handler;
    }

    public void setEventClass(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    public void setHandler(Consumer<T> handler) {
        this.handler = handler;
    }

    public void register() {
        EventHelper eventHelper = new EventHelper(Sickness.getInstance(), eventClass, handler);
        eventHelper.register();
        eventHelpers.add(eventHelper);
    }

    public void unregister() {
        for (EventHelper eventHelper : eventHelpers) {
            eventHelper.unregister();
            eventHelpers.remove(eventHelper);
        }
    }

    @EventHandler
    public void handle(T event) {
        if (eventClass.isInstance(event)) {
            handler.accept(event);
        }
    }
}
