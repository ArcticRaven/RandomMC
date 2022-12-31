package dev.arcticgaming.randomMC.Listeners;

import dev.arcticgaming.randomMC.Utils.SpawnNonHostileMobClass;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamagedEntityEventListener implements Listener {

    @EventHandler
    public void playerRandomEntityOnHit(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player) {

            Entity entity = event.getEntity();
            LivingEntity livingEntity = (LivingEntity) entity;
            Double healthValue = livingEntity.getHealth();
            Location location = event.getEntity().getLocation();

            if (event.getDamage() < healthValue) {
                entity.remove();
                new SpawnNonHostileMobClass().spawnNonHostileMob(location, healthValue, event.getDamage());
            }
        }
    }
}
