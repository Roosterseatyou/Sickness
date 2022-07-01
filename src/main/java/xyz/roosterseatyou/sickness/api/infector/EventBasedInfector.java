package xyz.roosterseatyou.sickness.api.infector;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.symptomhelp.EventHelper;

import java.util.ArrayList;
import java.util.function.Consumer;

public class EventBasedInfector<T extends Event> extends Infector implements Listener {
    private Class<T> eventClass;
    private Consumer<T> handler;
    private final ArrayList<EventHelper> eventHelpers = new ArrayList<>();

    public EventBasedInfector(Illness illness, Class<T> eventClass, Consumer<T> handler) {
        super(illness);
        this.eventClass = eventClass;
        this.handler = handler;
    }

    public void registerEvent() {
        EventHelper eventHelper = new EventHelper<>(Sickness.getInstance(), eventClass, handler);
        eventHelpers.add(eventHelper);
        eventHelper.register();
    }

    public void unregisterEvent() {
        for (EventHelper eventHelper : eventHelpers) {
            eventHelper.unregister();
            eventHelpers.remove(eventHelper);
        }
    }

    public void setHandler(Consumer<T> handler) {
        this.handler = handler;
    }
}
