package net.fabricmc.ajuu;

//import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CreativeCraft implements ModInitializer {
	/*----------创建对象----------*/
	public static final String MODID = "creativecraft";
	//创建物品栏
	public static final ItemGroup CREATIVE_CRAFT_GROUP = FabricItemGroupBuilder
			.build(new Identifier(MODID, "creativecraftgroup"),
			() -> new ItemStack(CreativeCraft.INLAY_GOLDEN_APPLE));
	//创建杂项物品
	public static final Item APPLE_BRANCH_BUNDLE = new Item(new Item.Settings().group(CREATIVE_CRAFT_GROUP));
	public static final Item INLAY_GOLDEN_APPLE = new Item(new Item.Settings().group(CREATIVE_CRAFT_GROUP)
			.food((new FoodComponent.Builder())
					.hunger(4)
					.saturationModifier(9.6F)
					.alwaysEdible()
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,2400),1.0F)
					.build())
			.maxCount(64));

	/*----------初始化----------*/
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MODID,"apple_branch_bundle"),APPLE_BRANCH_BUNDLE);
		Registry.register(Registry.ITEM, new Identifier(MODID,"inlay_golden_apple"),INLAY_GOLDEN_APPLE);
		OtherGoldenFood.register();
		EnderPearlBlock.register();
		OffensiveBlessingEnchantment.register();
		DefensiveBlessingEnchantment.register();
		ProofOfHero.register();
		OminousOfSeal.register();
		EndlessWaterBucket.register();
		EndlessLavaBucket.register();

		//System.out.println("Hello Fabric world!");
	}

}
