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

public class DefensiveBlessingEnchantment extends Enchantment {
    public DefensiveBlessingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(attacker instanceof LivingEntity){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,60,0,false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY,60,0,false,false,false));
            ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,60,0,false,false,false));
        }
    }

    public static void register(){
        Registry.register(Registry.ENCHANTMENT,new Identifier(CreativeCraft.MODID,"defensive_blessing_enchantment"),DEFENSIVE_BLESSING_ENCHANTMENT);
    }
    public static final DefensiveBlessingEnchantment DEFENSIVE_BLESSING_ENCHANTMENT=new DefensiveBlessingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
}