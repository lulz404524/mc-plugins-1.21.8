package de.customitems.armor;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsArmor extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomItems-Armor has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Armor has been disabled!");
    }
}
