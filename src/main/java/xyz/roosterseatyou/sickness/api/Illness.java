package xyz.roosterseatyou.sickness.api;

import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

import java.util.ArrayList;
import java.util.List;

public class Illness {
    private String name;
    private String description;
    private String cause;
    private List<SymptomHandler> symptomHandlers = new ArrayList<>();

    public Illness(String name, String description, String cause) {
        this.name = name;
        this.description = description;
        this.cause = cause;
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
}
