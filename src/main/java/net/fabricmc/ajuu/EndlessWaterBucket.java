package net.fabricmc.ajuu;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessWaterBucket extends BucketItem {
    public EndlessWaterBucket(Settings settings) {
        super(Fluids.WATER, settings.group(CreativeCraft.CREATIVE_CRAFT_GROUP).maxCount(1));
    }

    @Override
    protected ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return stack;
    }

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"endless_water_bucket"),ENDLESS_WATER_BUCKET);
    }
    public static final EndlessWaterBucket ENDLESS_WATER_BUCKET = new EndlessWaterBucket(new Item.Settings());
}
