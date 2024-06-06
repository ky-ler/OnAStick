package com.freezi.onastick.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ItemManager {
    private static ItemStack craftingStick;

    public void setCraftingStick (ItemStack item) {
        craftingStick = item;
    }

    public ItemStack getCraftingStick () {
        return craftingStick;
    }

    public ItemManager() {
        createCraftingStick();
    }

    private void createCraftingStick() {
        ItemStack item = new ItemBuilder(Material.CRAFTING_TABLE)
                .withName("Crafting Stick")
                .withEnchantment(Enchantment.LUCK, 1)
                .withItemFlag(ItemFlag.HIDE_ENCHANTS)
                .build();

        setCraftingStick(item);

        // Recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("portable_crafting_table"), craftingStick);
        sr.shape(" C ",
                 "S  ");
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('C', Material.CRAFTING_TABLE);

        Bukkit.removeRecipe(NamespacedKey.minecraft("portable_crafting_table"));
        Bukkit.addRecipe(sr);
    }

}
