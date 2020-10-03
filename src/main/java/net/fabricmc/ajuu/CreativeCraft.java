package net.fabricmc.ajuu;

//import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CreativeCraft implements ModInitializer {
	/*----------创建对象----------*/
	public static final String MODID = "creativecraft";
	//创建物品栏对象
	public static final ItemGroup CREATIVE_CRAFT_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "creativecraftgroup"), () -> new ItemStack(CreativeCraft.INLAY_GOLDEN_APPLE));
	//创建物品对象
	public static final Item APPLE_BRANCH_BUNDLE = new Item(new Item.Settings().group(CREATIVE_CRAFT_GROUP));
	public static final Item INLAY_GOLDEN_APPLE = new Item(new Item.Settings().group(CREATIVE_CRAFT_GROUP)
			.food((new FoodComponent.Builder())
					.hunger(4)
					.saturationModifier(9.6F)
					.alwaysEdible()
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,2400),1.0F)
					.build())
			.maxCount(64));
	public static final OtherGoldenFood GOLDEN_BEETROOT = new OtherGoldenFood("golden_beetroot",1,2.4F,StatusEffects.SPEED);
	public static final OtherGoldenFood GOLDEN_BREAD = new OtherGoldenFood("golden_bread",5,12F,StatusEffects.HASTE);
	public static final OtherGoldenFood GOLDEN_CHORUS_FRUIT = new OtherGoldenFood("golden_chorus_fruit",4,4.8F,StatusEffects.SLOW_FALLING);
	public static final OtherGoldenFood GOLDEN_COOKIE = new OtherGoldenFood("golden_cookie",2,0.8F,StatusEffects.LUCK);
	public static final OtherGoldenFood GOLDEN_ROTTEN_FLESH = new OtherGoldenFood("golden_rotten_flesh",4,1.6F,StatusEffects.STRENGTH);
	public static final OtherGoldenFood GOLDEN_CAKE = new OtherGoldenFood("golden_cake",14,5.6F,StatusEffects.SATURATION);
	public static final OtherGoldenFood GOLDEN_TROPICAL_FISH = new OtherGoldenFood("golden_tropical_fish",1,0.4F,StatusEffects.WATER_BREATHING);
	public static final OtherGoldenFood GOLDEN_PUMPKIN_PIE = new OtherGoldenFood("golden_pumpkin_pie",8,9.6F,StatusEffects.INVISIBILITY);
	public static final OtherGoldenFood GOLDEN_SWEET_BERRIES = new OtherGoldenFood("golden_sweet_berries",2,0.8F,StatusEffects.JUMP_BOOST);
	public static final OtherGoldenFood GOLDEN_SPIDER_EYE = new OtherGoldenFood("golden_spider_eye",2,6.4F,StatusEffects.NIGHT_VISION);
	//创建方块对象
	public static final EndePearlBlock ENDER_PEARL_BLOCK = new EndePearlBlock();
	//创建附魔书对象
	public static final OffensiveBlessingEnchantment OFFENSIVE_BLESSING_ENCHANTMENT=new OffensiveBlessingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	public static final DefensiveBlessingEnchantment DEFENSIVE_BLESSING_ENCHANTMENT=new DefensiveBlessingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});

	/*----------注册模组道具----------*/
	//注册物品
	public void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MODID,"apple_branch_bundle"),APPLE_BRANCH_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"inlay_golden_apple"),INLAY_GOLDEN_APPLE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_beetroot"),GOLDEN_BEETROOT);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_bread"),GOLDEN_BREAD);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_chorus_fruit"),GOLDEN_CHORUS_FRUIT);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_cookie"),GOLDEN_COOKIE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_rotten_flesh"),GOLDEN_ROTTEN_FLESH);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_cake"),GOLDEN_CAKE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_tropical_fish"),GOLDEN_TROPICAL_FISH);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_pumpkin_pie"),GOLDEN_PUMPKIN_PIE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_sweet_berries"),GOLDEN_SWEET_BERRIES);
		Registry.register(Registry.ITEM, new Identifier(MODID,"golden_spider_eye"),GOLDEN_SPIDER_EYE);
	}
	//注册方块及其方块物品
	public void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(MODID, "ender_pearl_block"), ENDER_PEARL_BLOCK);//注册方块
		Registry.register(Registry.ITEM, new Identifier(MODID, "ender_pearl_block"), new BlockItem(ENDER_PEARL_BLOCK, new Item.Settings().group(CREATIVE_CRAFT_GROUP)));
	}
	//注册附魔书
	public void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT,new Identifier(MODID,"offensive_blessing_enchantment"),OFFENSIVE_BLESSING_ENCHANTMENT);
		Registry.register(Registry.ENCHANTMENT,new Identifier(MODID,"defensive_blessing_enchantment"),DEFENSIVE_BLESSING_ENCHANTMENT);
	}

	/*----------初始化----------*/
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		registerItems();
		registerBlocks();
		registerEnchantment();

		//System.out.println("Hello Fabric world!");
	}

}
