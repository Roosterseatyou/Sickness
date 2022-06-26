package xyz.roosterseatyou.sickness.sicknesses;

import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.contagion.Contagion;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.sicknesses.symptoms.Puking;

public class FoodPoisoning extends Illness {
    public static FoodPoisoning FOOD_POISONING = new FoodPoisoning();

    private FoodPoisoning() {}

    @Override
    public void register() {
        //symptom handler
        SymptomHandler symptomHandler = new SymptomHandler(this);
        setSymptomHandler(symptomHandler);
        addSymptom(Puking.PUKING);
        symptomHandler.register();

        //contagion
        Contagion contagion = new Contagion(5, 20, 10, this);
        addContagion(contagion);
        contagion.register();
    }
}
