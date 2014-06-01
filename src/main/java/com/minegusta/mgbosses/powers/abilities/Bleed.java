package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Bleed implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 12, 0));
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "You did not ..SEE.. that comming!");

    }
}