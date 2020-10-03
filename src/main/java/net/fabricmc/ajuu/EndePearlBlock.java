package net.fabricmc.ajuu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

import java.util.List;

public class EndePearlBlock extends Block {
    public EndePearlBlock(){
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
}
