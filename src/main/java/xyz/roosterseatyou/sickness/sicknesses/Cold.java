package xyz.roosterseatyou.sickness.sicknesses;

import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.contagion.Contagion;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.sicknesses.symptoms.Sneezing;

public class Cold extends Illness {
    public static Cold COLD = new Cold();

    private Cold() {}

    @Override
    public void register() {
        //symptom handler
        Sickness.logger().info("Attempting to register SymptomHandler for Cold");
        SymptomHandler symptomHandler = new SymptomHandler(this);
        setSymptomHandler(symptomHandler);
        addSymptom(Sneezing.SNEEZING);
        symptomHandler.register();


        //contagion
        Contagion contagion = new Contagion(5, 20, 30, this);
        addContagion(contagion);
        contagion.register();
    }
}
