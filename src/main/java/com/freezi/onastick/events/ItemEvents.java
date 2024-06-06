package com.freezi.onastick.events;

import com.freezi.onastick.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemEvents implements Listener {
    private static ItemManager itemManager;

    public ItemEvents(ItemManager manager) {
        itemManager = manager;
    }

    @EventHandler
    public static void onRightClick(final PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
//            if (event.getItem() != null) {
            if (item.getItemMeta() != null
                    && item.getItemMeta().equals(itemManager.getCraftingStick().getItemMeta())) {
                // prevent placing block on ground
                event.setCancelled(true);
                player.openWorkbench(player.getLocation(), true);
            }

        }
    }
}
