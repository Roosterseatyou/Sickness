package xyz.roosterseatyou.sickness.sicknesses;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Cure;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.api.contagion.Contagion;
import xyz.roosterseatyou.sickness.api.infector.Infector;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.sicknesses.symptoms.Sneezing;
import xyz.roosterseatyou.sickness.utils.MathUtils;

public class Cold extends Illness {
    public static Cold COLD = new Cold();

    private Cold() {}

    @Override
    public void register() {
        //symptom handler
        SymptomHandler symptomHandler = new SymptomHandler(this);
        setSymptomHandler(symptomHandler);
        addSymptom(Sneezing.SNEEZING);
        symptomHandler.register();


        //contagion
        Contagion contagion = new Contagion(5, 20, 30, this);
        addContagion(contagion);
        contagion.register();

        //infector
        Infector infector = new Infector(this);
        infector.register(() -> {
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(!isInfected(p) && MathUtils.rngHelper(2)) {
                    infectPlayer(p);
                }
            }
        }, 20);

        //Cure
        setCure(new Cure<PlayerItemConsumeEvent>() {
            @Override
            public void register() {
                ItemStack item = new ItemStack(Material.POTION);
                PotionMeta meta = (PotionMeta) item.getItemMeta();
                meta.displayName(Component.text("Cold Cure"));
                meta.addCustomEffect(PotionEffectType.CONFUSION.createEffect(20 * 60, 1), true);
                item.setItemMeta(meta);

                setItem(item);
                setCureType(CureType.OTHER);

                setEventClass(PlayerItemConsumeEvent.class);

                setHandler((event) -> {
                    if(event.getItem().equals(item)) {
                        curePlayer(event.getPlayer());
                    }
                });

                registerEvent();
            }
            @Override
            public void curePlayer(Player player) {
                getPlayers().remove(player);
            }
        });

        getCure().register();
    }
}
