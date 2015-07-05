package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class GearUp implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        if(!(entity instanceof Zombie) && !(entity instanceof Skeleton))return;

        ItemStack[] armour;
        if(damager.getEquipment().getArmorContents().length != 0)
        {
            armour = damager.getEquipment().getArmorContents();
        } else return;

        if(entity instanceof Zombie)
        {
            Zombie zombie = (Zombie) entity;

            zombie.getEquipment().setArmorContents(armour);
            zombie.getEquipment().setLeggingsDropChance(0F);
            zombie.getEquipment().setBootsDropChance(0F);
            zombie.getEquipment().setHelmetDropChance(0F);
            zombie.getEquipment().setChestplateDropChance(0F);

        }
        if(entity instanceof Skeleton)
        {
            Skeleton skeleton = (Skeleton) entity;

            skeleton.getEquipment().setArmorContents(armour);
            skeleton.getEquipment().setLeggingsDropChance(0F);
            skeleton.getEquipment().setBootsDropChance(0F);
            skeleton.getEquipment().setHelmetDropChance(0F);
            skeleton.getEquipment().setChestplateDropChance(0F);
        }
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Nice armor! Lets see if it fits me...");
    }
}