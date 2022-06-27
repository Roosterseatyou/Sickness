package xyz.roosterseatyou.sickness.sicknesses;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.roosterseatyou.sickness.Sickness;
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
    }
}
