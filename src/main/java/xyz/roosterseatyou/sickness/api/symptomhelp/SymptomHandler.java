package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SymptomHandler implements Listener {
    private ArrayList<Symptom> symptoms = new ArrayList<>();
    private Illness illness;

    public SymptomHandler(Illness illness) {
        this.illness = illness;
    }

    public void register() {
        for (Symptom symptom : symptoms) {
            symptom.register();
        }
    }

    public void unregister() {
        for (Symptom symptom : symptoms) {
            symptom.unregister();
        }
    }

    public void addSymptom(Symptom symptom) {
        symptoms.add(symptom);
    }

    public void removeSymptom(Symptom symptom) {
        symptom.unregister();
        symptoms.remove(symptom);
    }

    public void clearSymptoms() {
        for (Symptom symptom : symptoms) {
            symptom.unregister();
        }
        symptoms.clear();
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}
