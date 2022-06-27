package xyz.roosterseatyou.sickness.sicknesses;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.contagion.Contagion;
import xyz.roosterseatyou.sickness.api.infector.EventBasedInfector;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.sicknesses.symptoms.Puking;
import xyz.roosterseatyou.sickness.utils.MathUtils;

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

        //infector
        EventBasedInfector<PlayerItemConsumeEvent> infector = new EventBasedInfector<PlayerItemConsumeEvent>(this, PlayerItemConsumeEvent.class, null);
        infector.setHandler((event) -> {
            ItemStack item = event.getItem();
            PlainTextComponentSerializer serializer = PlainTextComponentSerializer.plainText();
            if(serializer.serialize(item.displayName()).contains("Raw")) {
                if(MathUtils.rngHelper(20)) infectPlayer(event.getPlayer());
            }
        });
        infector.registerEvent();
    }
}
