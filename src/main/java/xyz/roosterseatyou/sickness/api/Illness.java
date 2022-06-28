package xyz.roosterseatyou.sickness.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import xyz.roosterseatyou.sickness.api.contagion.Contagion;
import xyz.roosterseatyou.sickness.api.infector.Infector;
import xyz.roosterseatyou.sickness.api.symptomhelp.Symptom;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class Illness {
    private static SymptomHandler symptomHandler;
    private Contagion contagion;
    private ArrayList<Player> players = new ArrayList<>();
    private boolean isContagious;
    private Infector infector;
    private Cure cure;

    protected abstract void register();

    public void setSymptomHandler(SymptomHandler symptomHandler) {
        Illness.symptomHandler = symptomHandler;
    }

    protected void addSymptom(Symptom symptom) {
        symptomHandler.addSymptom(symptom);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void updatePlayerList(ArrayList<Player> players) {
        this.players = players;
    }

    public void infectPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean isInfected(Player player) {
        return players.contains(player);
    }

    public void addContagion(Contagion contagion) {
        this.contagion = contagion;
        isContagious = true;
    }

    public Contagion getContagion() {
        return contagion;
    }

    public boolean isContagionActive() {
        return contagion.isRunning();
    }

    public boolean isContagious() {
        return isContagious;
    }

    public void setInfector(Infector infector) {
        this.infector = infector;
    }

    public Infector getInfector() {
        return infector;
    }

    public void setCure(Cure cure) {
        this.cure = cure;
    }

    public Cure getCure() {
        return cure;
    }
}
