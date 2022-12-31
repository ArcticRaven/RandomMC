package dev.arcticgaming.randomMC.Listeners;
import dev.arcticgaming.randomMC.randomMC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Random;

public class TeleportListener implements Listener {

    @EventHandler
    public void TeleportListener(PlayerTeleportEvent event) {

        Player player = event.getPlayer();
        Location location = event.getPlayer().getLocation();

        Random random = new Random();
        random.setSeed(randomMC.getPlugin(randomMC.class).getServer().getCurrentTick());

        if ((random.nextInt(10)+1) >= 8) {

            if (Bukkit.getServer().getCurrentTick() % 2 == 0) {

                Location newLocation = new Location(player.getWorld(),
                        random.nextDouble(Math.abs(location.getX() * 2)),
                        random.nextDouble(Math.abs(location.getY() * 2)),
                        random.nextDouble(Math.abs(location.getZ())) * 2);

                event.setTo(newLocation);
            } else {
                Location newLocation = new Location(player.getWorld(),
                        random.nextDouble(Math.abs(location.getX())) * -2,
                        random.nextDouble(location.getY()) * -2,
                        random.nextDouble(Math.abs(location.getZ())) * -2);

                event.setTo(newLocation);
            }

            if (!event.getTo().getBlock().isSolid() || event.getTo().getBlock().getRelative(BlockFace.UP).getType().isSolid()) {
                event.setTo(event.getTo().getBlock().getLocation().toHighestLocation());
            }
        }
    }
}
