package net.fabricmc.ajuu;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_beetroot"),GOLDEN_BEETROOT);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_bread"),GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_chorus_fruit"),GOLDEN_CHORUS_FRUIT);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_cookie"),GOLDEN_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_rotten_flesh"),GOLDEN_ROTTEN_FLESH);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_cake"),GOLDEN_CAKE);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_tropical_fish"),GOLDEN_TROPICAL_FISH);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_pumpkin_pie"),GOLDEN_PUMPKIN_PIE);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_sweet_berries"),GOLDEN_SWEET_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(CreativeCraft.MODID,"golden_spider_eye"),GOLDEN_SPIDER_EYE);
    }
    public static final OtherGoldenFood GOLDEN_BEETROOT = new OtherGoldenFood("golden_beetroot",1,2.4F, StatusEffects.SPEED);
    public static final OtherGoldenFood GOLDEN_BREAD = new OtherGoldenFood("golden_bread",5,12F,StatusEffects.HASTE);
    public static final OtherGoldenFood GOLDEN_CHORUS_FRUIT = new OtherGoldenFood("golden_chorus_fruit",4,4.8F,StatusEffects.SLOW_FALLING);
    public static final OtherGoldenFood GOLDEN_COOKIE = new OtherGoldenFood("golden_cookie",2,0.8F,StatusEffects.LUCK);
    public static final OtherGoldenFood GOLDEN_ROTTEN_FLESH = new OtherGoldenFood("golden_rotten_flesh",4,1.6F,StatusEffects.STRENGTH);
    public static final OtherGoldenFood GOLDEN_CAKE = new OtherGoldenFood("golden_cake",14,5.6F,StatusEffects.SATURATION);
    public static final OtherGoldenFood GOLDEN_TROPICAL_FISH = new OtherGoldenFood("golden_tropical_fish",1,0.4F,StatusEffects.WATER_BREATHING);
    public static final OtherGoldenFood GOLDEN_PUMPKIN_PIE = new OtherGoldenFood("golden_pumpkin_pie",8,9.6F,StatusEffects.INVISIBILITY);
    public static final OtherGoldenFood GOLDEN_SWEET_BERRIES = new OtherGoldenFood("golden_sweet_berries",2,0.8F,StatusEffects.JUMP_BOOST);
    public static final OtherGoldenFood GOLDEN_SPIDER_EYE = new OtherGoldenFood("golden_spider_eye",2,6.4F,StatusEffects.NIGHT_VISION);
}