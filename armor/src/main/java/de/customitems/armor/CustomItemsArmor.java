package de.customitems.armor;

import de.customitems.core.items.ItemManager;
import de.customitems.armor.commands.ArmorCommand;
import de.customitems.armor.items.ShadowChestplate;
import de.customitems.armor.listeners.ArmorListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsArmor extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register custom armor
        registerArmor();

        // Register commands
        getCommand("armor").setExecutor(new ArmorCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new ArmorListener(), this);

        getLogger().info("CustomItems-Armor has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Armor has been disabled!");
    }

    private void registerArmor() {
        ItemManager manager = ItemManager.getInstance();
        manager.registerItem(new ShadowChestplate());
        getLogger().info("Registered Shadow Chestplate");
    }
}
