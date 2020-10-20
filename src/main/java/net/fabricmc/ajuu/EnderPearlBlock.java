package net.fabricmc.ajuu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.List;

public class EnderPearlBlock extends Block {
    public EnderPearlBlock(){
        super(FabricBlockSettings.of(Material.SPONGE)
                .breakByHand(true)
                .breakByTool(FabricToolTags.HOES)
                .hardness(1)
                .sounds(BlockSoundGroup.SHROOMLIGHT)
                .lightLevel(7));
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("block.creativecraft.ender_pearl_block.tooltip"));
    }

    public static void register(){
        Registry.register(Registry.BLOCK, new Identifier(CreativeCraft.MODID, "ender_pearl_block"), ENDER_PEARL_BLOCK);//注册方块
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID, "ender_pearl_block"), new BlockItem(ENDER_PEARL_BLOCK, new Item.Settings().group(CreativeCraft.CREATIVE_CRAFT_GROUP)));
    }
    public static final EnderPearlBlock ENDER_PEARL_BLOCK = new EnderPearlBlock();
}
