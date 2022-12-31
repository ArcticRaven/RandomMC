package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PressurePlateListener implements Listener {

    @EventHandler
    public void liftedPressurePlates (PlayerInteractEvent event) {

        if (event.getClickedBlock() != null) {
            Player player = event.getPlayer();
            PotionEffect effect = null;

            switch (event.getClickedBlock().getType()) {

                case OAK_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 30, 10);
                    break;

                case SPRUCE_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 60, 20);
                    break;

                case ACACIA_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 80, 12);
                    break;

                case STONE_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 20, 10);
                    break;

                case LIGHT_WEIGHTED_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 50, 1);
                    break;

                case HEAVY_WEIGHTED_PRESSURE_PLATE:
                    effect = new PotionEffect(PotionEffectType.LEVITATION, 100, 1);
                    break;

                default:
                    break;

            }
            if (effect != null) {
                player.addPotionEffect(effect);
            }
        }
    }
}
