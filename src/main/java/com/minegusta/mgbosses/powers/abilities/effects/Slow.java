package com.minegusta.mgbosses.powers.abilities.effects;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Slow implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage)
    {
        damager.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 12, 0));
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "There's no escape!");
    }
}
