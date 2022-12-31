package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EntityDamageEventListener implements Listener {

    @EventHandler
    public void playerDamagedRandomizer(EntityDamageEvent event) {

        Entity entity = event.getEntity();
        Location location = entity.getLocation();

        Double incomingDamage = event.getDamage();
        Double damageLow = incomingDamage/2;
        Double damageHigh = incomingDamage * 1.5;

        if (entity instanceof Player) {
            Player player = (Player) entity;

            Random random = new Random();
            random.setSeed(random.nextInt(99999999));

            event.setDamage(random.nextDouble(damageHigh)+damageLow);
        }
    }
}
