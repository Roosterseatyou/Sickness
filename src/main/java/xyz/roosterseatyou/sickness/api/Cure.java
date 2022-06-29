package xyz.roosterseatyou.sickness.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.symptomhelp.EventHelper;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class Cure<T extends Event> {
    protected enum CureType {
        PILL,
        SHOT,
        OTHER
    }

    private Class<T> eventClass;

    private Consumer<T> handler;

    private CureType cureType;
    private ItemStack item;
    private SymptomHandler symptomHandler;
    private ArrayList<Illness> illnessesToCure = new ArrayList<>();
    private ArrayList<EventHelper> eventHelpers = new ArrayList<>();

    public void setSymptomHandler(SymptomHandler symptomHandler) {
        this.symptomHandler = symptomHandler;
    }

    public abstract void register();

    public void unregister() {
        symptomHandler.unregister();
    }

    public void setEventClass(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    public void setHandler(Consumer<T> handler) {
        this.handler = handler;
    }

    protected void registerEvent() {
        EventHelper eventHelper = new EventHelper<>(Sickness.getInstance(), eventClass, handler);
        eventHelpers.add(eventHelper);
        eventHelper.register();
    }

    public CureType getCureType() {
        return cureType;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setCureType(CureType cureType) {
        this.cureType = cureType;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public SymptomHandler getSymptomHandler() {
        return symptomHandler;
    }

    public abstract void curePlayer(Player player);

    public void addIllnessToCure(Illness illness) {
        illnessesToCure.add(illness);
    }

    public void removeIllnessToCure(Illness illness) {
        illnessesToCure.remove(illness);
    }

    public ArrayList<Illness> getIllnessesToCure() {
        return illnessesToCure;
    }


}
