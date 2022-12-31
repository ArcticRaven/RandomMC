package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Random;

public class PlayerEatListener implements Listener {

    @EventHandler
    public void randomSpeedOnEat(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();

        Random random = new Random();
        random.setSeed(random.nextInt(999999));

        player.setWalkSpeed(random.nextFloat(1));
        player.setHealthScale(random.nextDouble(40)+1);
        player.setHealth(random.nextDouble(40)+0.5);
        player.setRotation(random.nextFloat(360), random.nextFloat(360));
    }
}
