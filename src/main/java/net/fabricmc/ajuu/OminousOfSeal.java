package net.fabricmc.ajuu;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OminousOfSeal extends Item{
    private int level;
    public OminousOfSeal(Settings settings) {
        super(settings.group(CreativeCraft.CREATIVE_CRAFT_GROUP).maxCount(1).rarity(Rarity.RARE));
        level=0;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity){
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN,30,level));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(++level>4) level=0;
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
