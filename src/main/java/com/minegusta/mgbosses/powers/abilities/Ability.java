package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;

public interface Ability {

    public void run(LivingEntity damager, LivingEntity entity, double damage);
}
