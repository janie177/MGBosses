package com.minegusta.mgbosses.powers;

import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.powers.abilities.Ability;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class AbilityManager {

    private EntityDamageByEntityEvent e;
    private UUID uuid;
    private Player p;
    private LivingEntity entity;
    private double damage;

    public AbilityManager(EntityDamageByEntityEvent e)
    {
        this.e = e;
        this.uuid = e.getEntity().getUniqueId();
    }

    //Methods



    public boolean isBossMob()
    {
        return TempData.boss.containsKey(uuid);
    }

    public boolean isPlayer()
    {
        if(e.getDamager() instanceof Player)
        {
            p = (Player) e.getDamager();
            entity = (LivingEntity) e.getEntity();
            damage = e.getDamage();
            return true;
        }
        else if(e.getDamager() instanceof Arrow)
        {
            ProjectileSource source = ((Arrow) e.getDamager()).getShooter();
            if(source instanceof Player)
            {
                p = ((Player) source);
                entity = (LivingEntity) e.getEntity();
                damage = e.getDamage();
                return true;
            }
        }
        return false;
    }

    //Run the ability random chance thing.

    public void runAbility()
    {
        Boss boss = TempData.boss.get(uuid);
        List<String> abilities = boss.getAbilities();
        int abilityChance = boss.getAbilityChance();

        Random rand = new Random();
        int chance = rand.nextInt(100);

        if(!(abilityChance > chance))return;

        chance = rand.nextInt(abilities.size());
        Ability skill = Abilities.valueOf(abilities.get(chance).toLowerCase()).get();
        skill.run(p, entity, damage);

    }
}
