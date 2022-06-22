package xyz.roosterseatyou.sickness.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;

public abstract class Cure {
    enum CureType {
        PILL,
        SHOT,
        OTHER
    }

    private CureType cureType;
    private String name;
    private ItemStack item;
    private SymptomHandler symptomHandler;
    private ArrayList<Illness> illnessesToCure = new ArrayList<>();

    public void setSymptomHandler(SymptomHandler symptomHandler) {
        this.symptomHandler = symptomHandler;
    }

    public abstract void register();

    public void unregister() {
        symptomHandler.unregister();
    }

    public CureType getCureType() {
        return cureType;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setCureType(CureType cureType) {
        this.cureType = cureType;
    }

    public void setName(String name) {
        this.name = name;
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
}
