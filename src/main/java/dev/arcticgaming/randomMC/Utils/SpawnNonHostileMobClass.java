package dev.arcticgaming.randomMC.Utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.Random;
import java.util.UUID;

public class SpawnNonHostileMobClass {

    public boolean spawnNonHostileMob(Location location) {
        Random random = new Random();
        random.setSeed(random.nextInt(999999999));

        EntityType[] entityTypes = EntityType.values();
        org.bukkit.entity.EntityType testEntity = entityTypes[random.nextInt(entityTypes.length)];

        if (testEntity.isAlive()
                && testEntity != EntityType.WARDEN
                && testEntity != EntityType.ENDER_DRAGON
                && testEntity != EntityType.WITHER
                && testEntity != EntityType.DROPPED_ITEM
                && testEntity != EntityType.PLAYER
                && testEntity != EntityType.CAMEL) {

            World world = location.getWorld();
            world.spawnEntity(location, testEntity);
            return true;
        } else {
            spawnNonHostileMob(location);
        }
        return false;
    }

    public boolean spawnNonHostileMob(Location location, Double health, Double damage) {

        Random random = new Random();
        random.setSeed(random.nextInt(999999999));

        EntityType[] entityTypes = EntityType.values();
        org.bukkit.entity.EntityType testEntity = entityTypes[random.nextInt(entityTypes.length)];

        if (testEntity.isAlive()
                && testEntity != EntityType.WARDEN
                && testEntity != EntityType.ENDER_DRAGON
                && testEntity != EntityType.WITHER
                && testEntity != EntityType.ARMOR_STAND
                && testEntity != EntityType.PLAYER
                && testEntity != EntityType.CAMEL) {

            AttributeModifier modifierAdd = new AttributeModifier(UUID.randomUUID(), "Custom Max HP", testEntity.getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue(), AttributeModifier.Operation.ADD_NUMBER);

            World world = location.getWorld();
            UUID uuid = world.spawnEntity(location, testEntity).getUniqueId();

            Entity spawnedEntity = world.getEntity(uuid);
            LivingEntity convertedEntity = (LivingEntity) spawnedEntity ;

            if (testEntity.getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue() < health) {
                convertedEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(modifierAdd);
            }

            convertedEntity.setHealth(health - damage);

        } else {
            spawnNonHostileMob(location, health, damage);
        }
        return false;
    }
}
