package xyz.roosterseatyou.sickness.sicknesses;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

public class FoodPoisoning extends Illness {
    public static FoodPoisoning FOOD_POISONING = new FoodPoisoning();

    private FoodPoisoning() {}

    @Override
    public void register() {
        SymptomHandler symptomHandler = new SymptomHandler(this);
        setSymptomHandler(symptomHandler);
        addSymptom(Puking.PUKING);
        symptomHandler.register();
    }
}
