package net.tbbtly.increasedwheatdrops;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class HarvestListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(IncreasedWheatDrops.MOD_ID);

    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {

            if (!player.isCreative() && state.getBlock() == Blocks.WHEAT) {
                CropBlock wheatCrop = (CropBlock) state.getBlock();

                if (wheatCrop.getAge(state) == wheatCrop.getMaxAge()) {
                    Random rand = new Random();

                    //how much wheat drops
                    int wheatCount = rand.nextInt(2) + 1;

                    //fortune increase FABRIC IS DUMB AND I CANT SEE WHAT LEVEL OF FORTUNE A TOOL HAS
                    if (player.getMainHandItem().isEnchanted() && player.getMainHandItem().isEnchanted()) {

                        int fortuneLevel = 0;

                       // wheatCount += fortuneLevel;

                    }

                    //drop the generated amount of wheat
                    for (int i = 0; i < wheatCount; i++) {
                        wheatCrop.playerDestroy(level, player, pos, state, blockEntity, new ItemStack(Items.WHEAT));
                    }

                    //logger stuff
                    LOGGER.info("\n" + player.getMainHandItem() + "\n" + wheatCount + "\n" + player.getMainHandItem().getComponents());


                }
            }
        });
    }
}
