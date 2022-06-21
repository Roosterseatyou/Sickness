package xyz.roosterseatyou.sickness.api;

import org.bukkit.entity.Player;
import xyz.roosterseatyou.sickness.api.symptomhelp.Symptom;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;

public abstract class Illness {
    private static SymptomHandler symptomHandler;
    private ArrayList<Player> players = new ArrayList<>();

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
}
