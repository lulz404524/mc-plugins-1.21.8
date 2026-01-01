package de.customitems.core;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsCore extends JavaPlugin {

    private static CustomItemsCore instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("CustomItems-Core has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Core has been disabled!");
    }

    public static CustomItemsCore getInstance() {
        return instance;
    }
}
