package de.customitems.tools;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomItems-Tools has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Tools has been disabled!");
    }
}
