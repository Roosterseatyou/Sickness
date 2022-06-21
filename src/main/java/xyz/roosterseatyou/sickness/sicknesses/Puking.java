package xyz.roosterseatyou.sickness.sicknesses;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.sickness.api.symptomhelp.Symptom;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

public class Puking extends Symptom<PlayerItemConsumeEvent> {
    public Puking(Class<PlayerItemConsumeEvent> eventClass, SymptomHandler symptomHandler) {
        super(eventClass, symptomHandler);

        this.setHandler(event -> {
            if(event.getPlayer() == symptomHandler.getIllness().getPlayer()) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 60, 1));
                event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() - 3);
            }
        });
    }
}
