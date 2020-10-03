package net.fabricmc.ajuu;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class DefensiveBlessingEnchantment extends Enchantment {
    public DefensiveBlessingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(attacker instanceof LivingEntity){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,60));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY,60));
            ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,60));
        }
    }
}