package net.tbbtly.increasedwheatdrops;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncreasedWheatDrops implements ModInitializer {
	public static final String MOD_ID = "increasedwheatdrops";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		HarvestListener.register();
		LOGGER.info("Wheat Drops Increased!");

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
