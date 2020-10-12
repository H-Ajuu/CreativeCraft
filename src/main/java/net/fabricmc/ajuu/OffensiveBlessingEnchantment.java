package net.fabricmc.ajuu;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OffensiveBlessingEnchantment extends Enchantment {
    public OffensiveBlessingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,60,0,false,false,false));
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,60,0,false,false,false));
        }
    }

    public static void register(){
        Registry.register(Registry.ENCHANTMENT,new Identifier(CreativeCraft.MODID,"offensive_blessing_enchantment"),OFFENSIVE_BLESSING_ENCHANTMENT);
    }
    public static final OffensiveBlessingEnchantment OFFENSIVE_BLESSING_ENCHANTMENT=new OffensiveBlessingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
}