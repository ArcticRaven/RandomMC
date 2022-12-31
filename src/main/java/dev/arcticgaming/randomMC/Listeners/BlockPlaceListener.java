package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlockPlaceListener implements Listener {

    Map<Integer, BlockFace> blockFaceMap = new HashMap<>();

    @EventHandler
    public void onBlockPlace (BlockPlaceEvent event) {

        Random random = new Random();
        random.setSeed(random.nextLong(5555555));

        if (random.nextInt(10) >= 9) {
            blockFaceMap.put(1, BlockFace.UP);
            blockFaceMap.put(2, BlockFace.DOWN);
            blockFaceMap.put(3, BlockFace.EAST);
            blockFaceMap.put(4, BlockFace.WEST);
            blockFaceMap.put(5, BlockFace.NORTH);
            blockFaceMap.put(6, BlockFace.SOUTH);

            Block eventBlock = event.getBlock().getRelative(blockFaceMap.get(random.nextInt(6)));
            if (eventBlock.getType() == Material.AIR
                    && event.getBlockPlaced().getType() != Material.CHEST
                    && event.getBlockPlaced().getType() != Material.ENDER_CHEST
                    && event.getBlockPlaced().getType() != Material.SHULKER_BOX) {
                eventBlock.setType(event.getBlock().getType());
                event.setCancelled(true);
            }
        }
    }
}
