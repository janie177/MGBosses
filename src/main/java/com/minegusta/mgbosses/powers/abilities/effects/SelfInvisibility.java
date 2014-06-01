package com.minegusta.mgbosses.powers.abilities.effects;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SelfInvisibility implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        entity.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 8, 0));
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Try to harm me now!");
    }
}