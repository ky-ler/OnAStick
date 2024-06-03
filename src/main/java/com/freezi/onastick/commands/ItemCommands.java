package com.freezi.onastick.commands;

import com.freezi.onastick.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommands implements CommandExecutor {
    private final ItemManager itemManager;

    public ItemCommands(ItemManager manager) {
        itemManager = manager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You must be a player to use this command.");
            return true;
        }

        Player player = (Player) commandSender;

        if (command.getName().equalsIgnoreCase("givecraftingstick")) {
            // add crafting stick to player inventory
            player.getInventory().addItem(itemManager.getCraftingStick());
        }

        return true;
    }
}
