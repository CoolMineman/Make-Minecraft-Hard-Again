package io.github.coolmineman.makeminecrafthardagain;

import io.github.coolmineman.makeminecrafthardagain.rock.KnappingConsumer;
import io.github.coolmineman.makeminecrafthardagain.rock.RockBlock;
import io.github.coolmineman.makeminecrafthardagain.rock.RockItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MMHA implements ModInitializer {
	public static final Item ROCK = new RockItem(new Item.Settings().group(ItemGroup.MISC));
	public static final Item STONE_AXE_HEAD = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item STONE_SHOVEL_HEAD = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item STONE_HOE_HEAD = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item STONE_PICKAXE_HEAD = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item STONE_SWORD_HEAD = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Identifier KNAPPING_PACKET_ID = new Identifier("mmha", "knapping");

	public static final Block ROCK_BLOCK = new RockBlock(Settings.of(Material.STONE));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("mmha", "rock"), ROCK);
		Registry.register(Registry.ITEM, new Identifier("mmha", "stone_axe_head"), STONE_AXE_HEAD);
		Registry.register(Registry.ITEM, new Identifier("mmha", "stone_shovel_head"), STONE_SHOVEL_HEAD);
		Registry.register(Registry.ITEM, new Identifier("mmha", "stone_pickaxe_head"), STONE_PICKAXE_HEAD);
		Registry.register(Registry.ITEM, new Identifier("mmha", "stone_hoe_head"), STONE_HOE_HEAD);
		Registry.register(Registry.ITEM, new Identifier("mmha", "stone_sword_head"), STONE_SWORD_HEAD);

		ServerSidePacketRegistry.INSTANCE.register(KNAPPING_PACKET_ID, new KnappingConsumer());

		Registry.register(Registry.BLOCK, new Identifier("mmha", "rock"), ROCK_BLOCK);
		
		System.out.println("Hello Fabric world!");
	}
}
