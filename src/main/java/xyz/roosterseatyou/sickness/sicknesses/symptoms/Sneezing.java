package xyz.roosterseatyou.sickness.sicknesses.symptoms;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.symptomhelp.Symptom;
import xyz.roosterseatyou.sickness.api.symptomhelp.SymptomHandler;
import xyz.roosterseatyou.sickness.utils.MathUtils;

public class Sneezing extends Symptom {
    public static Sneezing SNEEZING = new Sneezing();

    private Sneezing() {}

    @Override
    public void register(SymptomHandler symptomHandler) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Sickness.getInstance(), () -> {
            for(Player p : symptomHandler.getIllness().getPlayers()) {
                if(MathUtils.rngHelper(40)) {
                    for(Player tar : p.getLocation().getNearbyPlayers(6)) {
                        if(MathUtils.rngHelper(30)) symptomHandler.getIllness().infectPlayer(tar);
                    }
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 3, 1));
                    ItemStack snot = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
                    ItemMeta snotMeta = snot.getItemMeta();
                    snotMeta.displayName(Component.text("Snot").color(TextColor.color(19, 82, 2)));
                    snot.setItemMeta(snotMeta);
                    p.getWorld().dropItem(p.getLocation(), snot);
                }
            }
        }, 0, 15*20);
    }
}
