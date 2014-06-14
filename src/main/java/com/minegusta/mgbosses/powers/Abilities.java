package com.minegusta.mgbosses.powers;

import com.minegusta.mgbosses.powers.abilities.*;
import com.minegusta.mgbosses.powers.abilities.effects.*;
import com.minegusta.mgbosses.powers.abilities.hordes.*;

public enum Abilities {

    //Make sure they are lowercase!!!!

    explode(new Explode()),
    blind(new Blind()),
    hunger(new Hunger()),
    selfdamageresistance(new SelfDamageResistance()),
    selffireresistance(new SelfFireResistance()),
    selfinvisibility(new SelfInvisibility()),
    poison(new Poison()),
    selfjump(new SelfJump()),
    selfregeneration(new SelfRegeneration()),
    selfspeed(new SelfStrength()),
    slow(new Slow()),
    weakness(new Weakness()),
    wither(new Wither()),
    batshield(new BatShield()),
    blazehorde(new BlazeHorde()),
    largeblazehorde(new LargeBlazeHorde()),
    cage(new Cage()),
    cavespiderhorde(new CaveSpiderHorde()),
    creeperhorde(new CreeperHorde()),
    endermanhorde(new EnderManHorde()),
    ghasthorde(new GhastHorde()),
    largecavespiderhorde(new LargeCaveSpiderHorde()),
    largecreeperhorde(new LargeCreeperHorde()),
    largeendermanhorde(new LargeEnderManHorde()),
    largeghasthorde(new LargeGhastHorde()),
    largemagmacubehorde(new LargeMagmaCubeHorde()),
    largesilverfishhorde(new LargeSilverFishHorde()),
    largeskeletonhorde(new LargeSkeletonHorde()),
    largeslimehorde(new LargeSlimeHorde()),
    largespiderhorde(new LargeSpiderHorde()),
    largewitchhorde(new LargeWitchHorde()),
    largewolfhorde(new LargeWolfHorde()),
    largezombiehorde(new LargeZombieHorde()),
    largezombiepigmanhorde(new LargeZombiePigManHorde()),
    magmacubehorde(new MagmaCubeHorde()),
    silverfishhorde(new SilverFishHorde()),
    skeletonhorde(new SkeletonHorde()),
    slimehorde(new SlimeHorde()),
    spiderhorde(new SpiderHorde()),
    witchhorde(new WitchHorde()),
    witherskeletonhorde(new WitherSkeletonHorde()),
    wolfhorde(new WolfHorde()),
    zombiephorde(new ZombiePigManHorde()),
    zombieminions(new ZombieMinions()),
    zombiepigmanhorde(new ZombiePigManHorde()),
    arrowrain(new ArrowRain()),
    bleed(new Bleed()),
    bringplayer(new BringPlayer()),
    choke(new Choke()),
    cloneweapon(new CloneWeapon()),
    damagepotionrain(new DamagePotionRain()),
    disarm(new Disarm()),
    entangle(new Entangle()),
    fire(new Fire()),
    fireball(new FireBall()),
    firebarrage(new FireBarrage()),
    gearup(new GearUp()),
    launch(new Launch()),
    lightning(new Lightning()),
    nuke(new Nuke()),
    poisonpotionrain(new PoisonPotionRain()),
    removearmour(new RemoveArmour()),
    slam(new Slam()),
    slownesspotionrain(new SlownessPotionRain()),
    smokescreen(new SmokeScreen()),
    squidrain(new SquidRain()),
    summonowl(new SummonOwl()),
    switchlocation(new SwitchLocation()),
    taunt(new Taunt()),
    selfstrength(new SelfStrength()),
    weaknesspotionrain(new WeaknessPotionRain());




    Ability abilityClass;

    private Abilities(Ability abilityClass)
    {
        this.abilityClass = abilityClass;
    }

    public Ability get()
    {
        return abilityClass;
    }


}
