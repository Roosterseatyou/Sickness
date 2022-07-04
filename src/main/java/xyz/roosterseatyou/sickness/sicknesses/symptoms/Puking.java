package xyz.roosterseatyou.sickness.sicknesses.symptoms;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.symptomhelp.Symptom;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;

public class Puking extends Symptom<PlayerItemConsumeEvent> {

    public static Puking PUKING = new Puking();
    private Puking() {}

    @Override
    public void register(SymptomHandler symptomHandler) {
        setHandler(event -> {
            if(symptomHandler.getIllness().isInfected(event.getPlayer())) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 60, 1));
                event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() - 3);
            }
        });
        setEventClass(PlayerItemConsumeEvent.class);
        registerEvent();
    }
}
