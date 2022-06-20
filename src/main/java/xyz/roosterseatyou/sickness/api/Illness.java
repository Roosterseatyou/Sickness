package xyz.roosterseatyou.sickness.api;

import org.bukkit.entity.Player;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;
import java.util.List;

public class Illness {
    private String name;
    private String description;
    private String cause;
    private Player player;
    private int durationInMinutes;
    private List<SymptomHandler> symptomHandlers = new ArrayList<>();

    public Illness(String name, String description, String cause, Player player, int durationInMinutes) {
        this.name = name;
        this.description = description;
        this.cause = cause;
        this.player = player;
        this.durationInMinutes = durationInMinutes;
    }

    public void register() {
        Registry.registerIllness(this);
    }

    public void unregister() {
        Registry.unregisterIllness(this);
    }

    public void addSymptomHandler(SymptomHandler symptomHandler) {
        symptomHandler.register();
        symptomHandlers.add(symptomHandler);
    }

    public void removeSymptomHandler(SymptomHandler symptomHandler) {
        symptomHandler.unregister();
        symptomHandlers.remove(symptomHandler);
    }

    public void stopAffecting() {
        for (SymptomHandler symptomHandler : symptomHandlers) {
            symptomHandler.unregister();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCause() {
        return cause;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
