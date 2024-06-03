package com.freezi.onastick;

import com.freezi.onastick.events.ItemEvents;
import com.freezi.onastick.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class OnAStick extends JavaPlugin {

    private final ItemManager itemManager = new ItemManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + this.getName() + " Enabled");
        ItemManager itemManager = new ItemManager();
        getServer().getPluginManager().registerEvents(new ItemEvents(itemManager), this);
//        getCommand("givecraftingstick").setExecutor(new ItemCommands(itemManager));
    }

    @Override
    public void onDisable() {
        Bukkit.resetRecipes();
        // Plugin shutdown logic
    }


}
