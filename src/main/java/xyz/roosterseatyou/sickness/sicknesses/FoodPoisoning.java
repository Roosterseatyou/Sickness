package xyz.roosterseatyou.sickness.sicknesses;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

public class FoodPoisoning extends Illness {

    public FoodPoisoning(Player player, int durationInMinutes) {
        super("FoodPoisoning", "You are poisoned by food", "You are poisoned by food", player, durationInMinutes);

        SymptomHandler symptomHandler = new SymptomHandler(this);
        symptomHandler.addSymptom(new Puking(PlayerItemConsumeEvent.class, symptomHandler));
        addSymptomHandler(symptomHandler);
        register();
    }
}
