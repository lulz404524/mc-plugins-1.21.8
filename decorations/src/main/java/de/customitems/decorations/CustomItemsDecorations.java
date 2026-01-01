package de.customitems.decorations;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsDecorations extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomItems-Decorations has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Decorations has been disabled!");
    }
}
