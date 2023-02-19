package net.violencity.advancing_technology.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.violencity.advancing_technology.AdvancingTechnology;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, AdvancingTechnology.MOD_ID);

    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FUEL).stacksTo(64)
                    .fireResistant()));

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FUEL).stacksTo(64)
                    .fireResistant()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
