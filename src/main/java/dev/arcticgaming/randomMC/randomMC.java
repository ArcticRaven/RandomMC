package dev.arcticgaming.randomMC;

import dev.arcticgaming.randomMC.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class randomMC extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //########################[ COMPLETED ]#################################
        //scramble teleport commands
        //      - happens on % chance UwU
        //planting crops is random
        //sneak-placing blocks randomizes what they are
        //      - this does not affect Chests or Ender-chests
        //      - happens on % chance UwU
        //placing blocks has a % chance to offset by 1 value
        //trees grow up into different types of trees... and stuff...
        //chickens will occasionally lay not eggs...
        //consuming food randomly changes player attributes
        //creature spawns have a % chance of being random
        //damage is randomized!
        //if an entity is not killed by damage, it turns into a new Living Entity
        //Portals now send you to random dimensions...
        //Pressure Plates give levitation!
        //Mining Ores will occasionally not drop what they're supposed to...
        //########################[ DELAYED ]##################################
        //scramble potion effects
        //      - Will need to use Packet Magic to identify potion effects and such, lil hacky...
        //#########################[ TO DO ]###################################
        //Chance of a random player being killed instead of you... rip.

        Bukkit.getPluginManager().registerEvents(this, this);
        final PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new TeleportListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new TreeSwapperListener(), this);
        pm.registerEvents(new EggLayListener(), this);
        pm.registerEvents(new PlayerEatListener(), this);
        pm.registerEvents(new CreatureSpawnEventListener(), this);
        pm.registerEvents(new PlayerJumpEventListener(), this);
        pm.registerEvents(new EntityDamageEventListener(), this);
        pm.registerEvents(new PressurePlateListener(), this);
        pm.registerEvents(new EntityDamagedEntityEventListener(), this);
        pm.registerEvents(new PlayerPortalEventListener(), this);
        pm.registerEvents(new RandomOreListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic


    }
}
