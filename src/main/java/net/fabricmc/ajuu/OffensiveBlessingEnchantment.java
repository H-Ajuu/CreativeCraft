package net.fabricmc.ajuu;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class OffensiveBlessingEnchantment extends Enchantment {
    public OffensiveBlessingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,60));
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,60));
        }
    }
}