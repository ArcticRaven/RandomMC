package dev.arcticgaming.randomMC.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class RandomOreListener implements Listener {

    @EventHandler
    public void randomOreGenerator (BlockBreakEvent event) {

        Player player = event.getPlayer();

        Random random = new Random();

        List<ItemStack> dropsSingle = new ArrayList<>();
        ItemStack coal = new ItemStack(Material.COAL);
        ItemStack copper = new ItemStack(Material.RAW_COPPER);
        ItemStack iron = new ItemStack(Material.RAW_IRON);
        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemStack gold = new ItemStack(Material.RAW_GOLD);
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack emerald = new ItemStack(Material.EMERALD);

        dropsSingle.add(coal);
        dropsSingle.add(copper);
        dropsSingle.add(iron);
        dropsSingle.add(lapis);
        dropsSingle.add(redstone);
        dropsSingle.add(gold);
        dropsSingle.add(diamond);
        dropsSingle.add(emerald);

        Material[] oreBlocks = {
                Material.COAL_ORE,
                Material.COPPER_ORE,
                Material.IRON_ORE,
                Material.LAPIS_ORE,
                Material.REDSTONE_ORE,
                Material.GOLD_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,
                Material.DEEPSLATE_COAL_ORE,
                Material.DEEPSLATE_COPPER_ORE,
                Material.DEEPSLATE_IRON_ORE,
                Material.DEEPSLATE_LAPIS_ORE,
                Material.DEEPSLATE_REDSTONE_ORE,
                Material.DEEPSLATE_GOLD_ORE,
                Material.DEEPSLATE_DIAMOND_ORE};


        World world = event.getBlock().getWorld();
        int chance = random.nextInt(20);

        if (Arrays.asList(oreBlocks).contains(event.getBlock().getType()) && chance >= 16) {
            event.setDropItems(false);
            int i = random.nextInt(3);
            while (i >= 0) {
                world.dropItem(event.getBlock().getLocation(), dropsSingle.get(random.nextInt(dropsSingle.size())));
                i--;
            }
        }
    }
}
