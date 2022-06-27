package xyz.roosterseatyou.sickness.api.infector;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.roosterseatyou.sickness.Sickness;
import xyz.roosterseatyou.sickness.api.Illness;

public class Infector {
    private Illness illness;
    private int runnableId;
    private boolean isRunning;

    public Infector(Illness illness) {
        this.illness = illness;
    }

    public boolean register(Runnable runnable, int delay) {
        if (isRunning) {
            return false;
        }
        runnableId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Sickness.getInstance(), runnable, 0, delay);
        isRunning = true;
        return true;
    }

    public boolean unregister() {
        if (!isRunning) {
            return false;
        }
        Bukkit.getScheduler().cancelTask(runnableId);
        isRunning = false;
        return true;
    }

}
