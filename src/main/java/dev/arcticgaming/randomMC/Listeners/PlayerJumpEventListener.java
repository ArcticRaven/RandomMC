package dev.arcticgaming.randomMC.Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class PlayerJumpEventListener implements Listener {

    @EventHandler
    public void playerJumpCanceller(PlayerJumpEvent event) {

        Random random = new Random();
        random.setSeed(random.nextInt(999999999));

        if (random.nextInt(20) >= 18) {
            event.setCancelled(true);
        }
    }
}
