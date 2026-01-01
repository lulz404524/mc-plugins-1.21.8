package de.customitems.weapons;

import de.customitems.core.items.ItemManager;
import de.customitems.weapons.commands.WeaponCommand;
import de.customitems.weapons.items.FlamesSword;
import de.customitems.weapons.listeners.WeaponListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsWeapons extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register custom weapons
        registerWeapons();

        // Register commands
        getCommand("weapon").setExecutor(new WeaponCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new WeaponListener(), this);

        getLogger().info("CustomItems-Weapons has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Weapons has been disabled!");
    }

    private void registerWeapons() {
        ItemManager manager = ItemManager.getInstance();
        manager.registerItem(new FlamesSword());
        getLogger().info("Registered Flames Sword");
    }
}
