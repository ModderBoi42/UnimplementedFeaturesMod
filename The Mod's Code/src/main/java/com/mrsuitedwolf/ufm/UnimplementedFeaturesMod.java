package com.mrsuitedwolf.ufm;

import com.mrsuitedwolf.ufm.init.BlockInit;
import com.mrsuitedwolf.ufm.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ufm")
public class UnimplementedFeaturesMod {
	
	public static final String MOD_ID = "ufm";
	
	public static final CreativeModeTab FIRST_VERSION_TAB = new CreativeModeTab(MOD_ID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.LEATHER_BLOCK.get());
		}
	};
	
	public UnimplementedFeaturesMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
