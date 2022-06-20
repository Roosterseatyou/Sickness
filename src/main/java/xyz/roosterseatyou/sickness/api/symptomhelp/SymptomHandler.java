package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Event;
import xyz.roosterseatyou.sickness.Sickness;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SymptomHandler<T extends Event> {
    private Consumer<T> func;
    private Class<T> eventClass;
    private ArrayList<EventHelper> eventHelpers = new ArrayList<>();

    public SymptomHandler(Consumer<T> func, Class<T> eventClass) {
        this.func = func;
        this.eventClass = eventClass;
    }

    public void addSymptom(Consumer<T> func, Class<T> eventClass) {
        EventHelper eventHelper = new EventHelper(Sickness.getInstance(), eventClass, func);
        eventHelper.register();
        eventHelpers.add(eventHelper);
    }

    public void setFunction(Consumer<T> func) {
        this.func = func;
    }

    public void setEventClass(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    public void register() {
        new EventHelper<>(Sickness.getInstance(), eventClass, func).register();
        eventHelpers.add(new EventHelper<>(Sickness.getInstance(), eventClass, func));
    }

    public void unregister() {
        for (EventHelper eventHelper : eventHelpers) {
            eventHelper.unregister();
            eventHelpers.remove(eventHelper);
        }
    }
}
