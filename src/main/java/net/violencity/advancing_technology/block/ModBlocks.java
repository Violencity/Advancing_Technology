package net.violencity.advancing_technology.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.violencity.advancing_technology.AdvancingTechnology;
import net.violencity.advancing_technology.block.custom.PetroleumContainerBlock;
import net.violencity.advancing_technology.item.ModCreativeModeTab;
import net.violencity.advancing_technology.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS,
                    AdvancingTechnology.MOD_ID);

    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock(
            "uranium_block", () -> new Block(BlockBehaviour.Properties.of
                    (Material.METAL).requiresCorrectToolForDrops().strength(6f)
                    .explosionResistance(8f)), ModCreativeModeTab.FUEL);

    public static final RegistryObject<Block> RAW_URANIUM_BLOCK = registerBlock(
            "raw_uranium_block", () -> new Block(BlockBehaviour.Properties.of
                            (Material.METAL).requiresCorrectToolForDrops().strength(6f)
                    .explosionResistance(8f)), ModCreativeModeTab.FUEL);

    public static final RegistryObject<Block> URANINITE = registerBlock(
            "uraninite", () -> new DropExperienceBlock(BlockBehaviour.Properties.of
                            (Material.METAL).requiresCorrectToolForDrops().strength(6f)
                    .explosionResistance(8f), UniformInt.of(4, 9)), ModCreativeModeTab.FUEL);

    public static final RegistryObject<Block> PETROLEUM_CONTAINER = registerBlock(
            "petroleum_container", () -> new PetroleumContainerBlock(BlockBehaviour.Properties.of
                            (Material.METAL).requiresCorrectToolForDrops().strength(6f)
                    .explosionResistance(8f).noOcclusion()), ModCreativeModeTab.FUEL);



    private static <T extends Block> RegistryObject<T> registerBlock(String name,
                                                                     Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                            RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
