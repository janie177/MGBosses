package com.minegusta.mgbosses.powers.abilities.effects;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Weakness implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 12, 0));
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "You are weak!");
    }
}