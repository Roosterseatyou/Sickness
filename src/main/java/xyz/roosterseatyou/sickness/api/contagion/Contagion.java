package xyz.roosterseatyou.sickness.api.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;
import xyz.roosterseatyou.sickness.utils.MathUtils;

public class Contagion {
    private int radius;
    private int repeatTime;
    private int chanceOfSpread;
    private Illness illness;
    private int runnableId;
    private boolean isRunning;

    public Contagion(int radius, int repeatTime, int chanceOfSpread, Illness illness) {
        this.radius = radius;
        this.repeatTime = repeatTime;
        this.chanceOfSpread = chanceOfSpread;
        this.illness = illness;
    }

    public int getRadius() {
        return radius;
    }

    public int getRepeatTime() {
        return repeatTime;
    }

    public int getChanceOfSpread() {
        return chanceOfSpread;
    }

    public void spread(Player player) {
        illness.infectPlayer(player);
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setRepeatTime(int repeatTime) {
        this.repeatTime = repeatTime;
    }

    public void setChanceOfSpread(int chanceOfSpread) {
        this.chanceOfSpread = chanceOfSpread;
    }

    public void register() {
        runnableId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Sickness.getInstance(), () -> {
            for(Player p : illness.getPlayers()) {
                for(Player tar : p.getLocation().getNearbyPlayers(radius)) {
                    if(MathUtils.rngHelper(chanceOfSpread)) {
                        spread(tar);
                    }
                }
            }
        }, 0, repeatTime);
        isRunning = true;
    }

    public void unregister() {
        Bukkit.getScheduler().cancelTask(runnableId);
        isRunning = false;
    }

    public int getRunnableId() {
        return runnableId;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
