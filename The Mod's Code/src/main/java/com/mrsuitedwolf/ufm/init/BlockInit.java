package com.mrsuitedwolf.ufm.init;

import java.util.function.Function;

import com.google.common.base.Supplier;
import com.mrsuitedwolf.ufm.UnimplementedFeaturesMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			UnimplementedFeaturesMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

	public static final RegistryObject<Block> LEATHER_BLOCK = register("leather_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN).strength(1.0f, 2.0f)
					.sound(SoundType.WOOL)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UnimplementedFeaturesMod.FIRST_VERSION_TAB)));
	
	public static final RegistryObject<Block> BLACK_PLANKS = register("black_planks",
			() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).strength(2.0f, 3.0f)
					.sound(SoundType.WOOD)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UnimplementedFeaturesMod.FIRST_VERSION_TAB)));

	public static final RegistryObject<Block> BLACK_SLAB = register("black_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).strength(2.0f, 3.0f)
					.sound(SoundType.WOOD)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UnimplementedFeaturesMod.FIRST_VERSION_TAB)));
	
	public static final RegistryObject<Block> CHARCOAL_BLOCK = register("charcoal_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(5.0f, 6.0f)
					.sound(SoundType.WOOD).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UnimplementedFeaturesMod.FIRST_VERSION_TAB)));
	
	//public static final RegistryObject<Block> BLOCK_NAME = register("block_name",
		  //() -> new Block(BlockBehaviour.Properties.of(Material., MaterialColor.).strength(0.0f, 0.0f)
				  //.sound(SoundType.)),
		  //object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UnimplementedFeaturesMod.FIRST_VERSION_TAB)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name,
			final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
