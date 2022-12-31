package dev.arcticgaming.randomMC.Listeners;

import dev.arcticgaming.randomMC.Utils.SpawnNonHostileMobClass;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Random;

public class CreatureSpawnEventListener implements Listener {


    @EventHandler
    public void animalSpawn(CreatureSpawnEvent event) {

        Random random = new Random();
        random.setSeed(random.nextInt(999999999));

        if (event.getEntity() instanceof Player) {
        } else {
            if (random.nextInt(10) >= 9) {
                Location location = event.getLocation();

                if (new SpawnNonHostileMobClass().spawnNonHostileMob(location)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
