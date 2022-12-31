package dev.arcticgaming.randomMC.Listeners;

import dev.arcticgaming.randomMC.randomMC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;

import java.util.Random;

public class EggLayListener implements Listener {

    @EventHandler
    public void chickenLayBombs(EntityDropItemEvent event) {

        if (event.getEntityType() == EntityType.CHICKEN
                && event.getItemDrop().getItemStack().getType() == Material.EGG) {

            Random random = new Random();
            random.setSeed(random.nextInt(999999));

            if (random.nextInt(10) >= 9) {

                event.getItemDrop().getItemStack().setType(Material.AIR);
                Location location = event.getEntity().getLocation();
                World world = location.getWorld();

                world.spawnEntity(location, EntityType.PRIMED_TNT);
            }
        }
    }
}
