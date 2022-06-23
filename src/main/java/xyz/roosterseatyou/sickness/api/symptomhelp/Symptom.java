package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.roosterseatyou.sickness.Sickness;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class Symptom<T extends Event> {
    private Class<T> eventClass;
    private Consumer<T> handler;
    private final ArrayList<EventHelper> eventHelpers = new ArrayList<>();
    private SymptomHandler symptomHandler;

    public abstract void register(SymptomHandler symptomHandler);

    public void unregister() {
        for (EventHelper eventHelper : eventHelpers) {
            eventHelper.unregister();
            eventHelpers.remove(eventHelper);
        }
    }

    public void registerEvent() {
        EventHelper eventHelper = new EventHelper<>(Sickness.getInstance(), eventClass, handler);
        eventHelpers.add(eventHelper);
        eventHelper.register();
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

    public void setSymptomHandler(SymptomHandler symptomHandler) {
        this.symptomHandler = symptomHandler;
    }

    public SymptomHandler getSymptomHandler() {
        return symptomHandler;
    }
}
