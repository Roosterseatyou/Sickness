package xyz.roosterseatyou.sickness.api.symptomhelp;

import org.bukkit.event.Listener;
import xyz.roosterseatyou.sickness.api.Illness;

import java.util.ArrayList;

public class SymptomHandler implements Listener {
    private ArrayList<Symptom> symptoms = new ArrayList<>();
    private Illness illness;

    public SymptomHandler(Illness illness) {
        this.illness = illness;
    }

    public SymptomHandler() {}

    public void register() {
        // no need to register the symptoms manually, since that will be handled here,
        // and will only register symptoms in use.
        for (Symptom symptom : symptoms) {
            symptom.register(this);
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
