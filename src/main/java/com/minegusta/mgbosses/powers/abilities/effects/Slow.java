package com.minegusta.mgbosses.powers.abilities.effects;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Jan on 1-6-2014.
 */
public class Slow implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 0));
    }
}
