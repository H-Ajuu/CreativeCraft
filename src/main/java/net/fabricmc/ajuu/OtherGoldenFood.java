package net.fabricmc.ajuu;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import java.util.List;

public class OtherGoldenFood extends Item {

    private final String myname;
    public OtherGoldenFood(String nm,int hg, float sm, StatusEffect se)
    {
        super(new Item.Settings().group(CreativeCraft.CREATIVE_CRAFT_GROUP)
                .food((new FoodComponent.Builder())
                        .hunger(hg)
                        .saturationModifier(sm)
                        .alwaysEdible()
                        .statusEffect(new StatusEffectInstance(se,1200),1.0F)
                        .build())
                .maxCount(64));
        myname=nm;
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.creativecraft."+myname+".tooltip"));
    }
}