package net.violencity.advancing_technology.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FUEL = new CreativeModeTab("fuel") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.URANIUM.get());
        }
    };
}
