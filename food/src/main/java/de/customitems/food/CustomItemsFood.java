package de.customitems.food;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsFood extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomItems-Food has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Food has been disabled!");
    }
}
