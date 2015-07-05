package com.minegusta.mgbosses.powers.abilities.effects;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SelfDamageResistance implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 12, 0));
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I used harden! I don't even feel your strikes anymore!");
    }
}