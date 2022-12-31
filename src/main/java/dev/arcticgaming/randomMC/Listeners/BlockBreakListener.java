package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Arrays;
import java.util.Random;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void changeCrops(BlockPlaceEvent event){

        Block eventBlock = event.getBlockPlaced();
        Player player = event.getPlayer();

        Random random = new Random();
        random.setSeed(random.nextLong(55555555)+1);

        Material[] cropBlocks = {Material.WHEAT, Material.POTATOES, Material.BEETROOTS, Material.CARROTS, Material.PUMPKIN_STEM, Material.MELON_STEM};

        if (player.isSneaking()) {
            if ((random.nextInt(10)+1) >= 7 && eventBlock.getType() != Material.CHEST && eventBlock.getType() != Material.ENDER_CHEST) {

                Material[] materials = Material.values();
                eventBlock.setType(materials[random.nextInt(materials.length)]);
            }
        }

        if (Arrays.asList(cropBlocks).contains(eventBlock.getType())){
            eventBlock.setType(cropBlocks[random.nextInt(6)]);
        }
    }
}
