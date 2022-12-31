package dev.arcticgaming.randomMC.Listeners;

import dev.arcticgaming.randomMC.randomMC;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import java.util.List;
import java.util.Random;

public class PlayerPortalEventListener implements Listener {

    public Boolean findSpawnableLocation(Player player, Location location) {
        Random random = new Random();
        int i = 0;
        while (i < 1000) {
            location.setX(location.getX() + random.nextInt(10000));
            location.setY(0);
            location.setZ(location.getZ() + random.nextInt(10000));
            location.getChunk().load();
            try {
                if (location.toHighestLocation().getBlock().isSolid()
                        && !location.toHighestLocation().getBlock().getType().isAir()
                        && !location.toHighestLocation().getBlock().getType().isEmpty()) {
                    player.teleport(location.toHighestLocation());
                    randomMC.getPlugin(randomMC.class).getLogger().info("Total Attempted Teleports: " + i);
                    return true;
                }
            } finally {
                location.getChunk().unload();
                i++;
            }
        }
        return false;
    }

    @EventHandler
    public void randomPlayerDimensions(PlayerPortalEvent event) {

        event.setCancelled(true);
        Server server = Bukkit.getServer();
        List<World> worlds = server.getWorlds();

        Random random = new Random();
        random.setSeed(random.nextInt(99999999));

        event.getTo().setWorld(worlds.get(random.nextInt(worlds.size())));

        Location destination = event.getTo();
        if (!findSpawnableLocation(event.getPlayer(), destination)) {
            event.getPlayer().sendMessage("Oh you wanted to leave? oops...");
        }
    }
}
