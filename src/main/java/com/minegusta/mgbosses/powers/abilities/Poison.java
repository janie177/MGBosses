package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Poison implements Ability {



    public Poison()
    {

    }

    @Override
    public String getName()
    {
        return "Poison";
    }

    @Override
    public void run(Player p, LivingEntity entity, double damage)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
    }
}
