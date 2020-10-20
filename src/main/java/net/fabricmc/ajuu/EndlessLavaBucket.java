package net.fabricmc.ajuu;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndlessLavaBucket extends BucketItem {
    public EndlessLavaBucket(Settings settings) {
        super(Fluids.LAVA, settings.group(CreativeCraft.CREATIVE_CRAFT_GROUP).maxCount(1));
    }

    @Override
    protected ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return stack;
    }

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"endless_lava_bucket"),ENDLESS_LAVA_BUCKET);
    }
    public static final EndlessLavaBucket ENDLESS_LAVA_BUCKET = new EndlessLavaBucket(new Item.Settings());
}
