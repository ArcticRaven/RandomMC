package dev.arcticgaming.randomMC.Listeners;

import dev.arcticgaming.randomMC.randomMC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TreeSwapperListener implements Listener {

    Map <Integer, TreeType> treeTypes = new HashMap<>();

    @EventHandler
    public void onStructureGrow(StructureGrowEvent event) {

        treeTypes.put(1, TreeType.TREE);
        treeTypes.put(2, TreeType.BIG_TREE);
        treeTypes.put(3, TreeType.ACACIA);
        treeTypes.put(4, TreeType.AZALEA);
        treeTypes.put(5, TreeType.BIRCH);
        treeTypes.put(6, TreeType.JUNGLE);
        treeTypes.put(7, TreeType.JUNGLE_BUSH);
        treeTypes.put(8, TreeType.MANGROVE);
        treeTypes.put(9, TreeType.REDWOOD);
        treeTypes.put(10, TreeType.SMALL_JUNGLE);
        treeTypes.put(11, TreeType.SWAMP);
        treeTypes.put(12, TreeType.TALL_BIRCH);
        treeTypes.put(13, TreeType.BROWN_MUSHROOM);
        treeTypes.put(14, TreeType.RED_MUSHROOM);
        treeTypes.put(15, TreeType.CHORUS_PLANT);
        treeTypes.put(16, TreeType.CRIMSON_FUNGUS);
        treeTypes.put(17, TreeType.WARPED_FUNGUS);

        Location location = event.getLocation();
        World world = event.getWorld();

        Random random = new Random();
        random.setSeed(random.nextInt(999999999));

        int randomTreeType = random.nextInt(treeTypes.size());

        event.setCancelled(true);

        switch (randomTreeType) {

            case 13:
            case 14:
                event.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.PODZOL);
                break;

            case 15:
                event.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.END_STONE);
                break;

            case 16:
                event.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.CRIMSON_NYLIUM);
                break;
            case 17:
                event.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.WARPED_NYLIUM);
                break;

            default:
        }

        event.getLocation().getBlock().setType(Material.AIR);
        world.generateTree(location, treeTypes.get(randomTreeType));
    }
}
