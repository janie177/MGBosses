package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class CloneWeapon implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        if(!(entity instanceof Zombie) && !(entity instanceof Skeleton))return;

        if(!(damager instanceof Player)) return;

        Player p = (Player) damager;

        ItemStack weapon;
        if(!p.getItemInHand().getType().equals(Material.AIR))
        {
            weapon = p.getItemInHand();
        } else return;

        if(entity instanceof Zombie)
        {
            Zombie zombie = (Zombie) entity;
            zombie.getEquipment().setItemInHand(weapon);
            zombie.getEquipment().setItemInHandDropChance(0F);
        }
        if(entity instanceof Skeleton)
        {
            Skeleton skeleton = (Skeleton) entity;
            skeleton.getEquipment().setItemInHand(weapon);
            skeleton.getEquipment().setItemInHandDropChance(0F);
        }
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I will use your own weapon against you!");
    }
}