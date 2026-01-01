package de.customitems.food;

import de.customitems.core.items.ItemManager;
import de.customitems.food.commands.FoodCommand;
import de.customitems.food.items.MagicApple;
import de.customitems.food.listeners.FoodListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsFood extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register custom food
        registerFood();

        // Register commands
        getCommand("food").setExecutor(new FoodCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new FoodListener(), this);

        getLogger().info("CustomItems-Food has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Food has been disabled!");
    }

    private void registerFood() {
        ItemManager manager = ItemManager.getInstance();
        manager.registerItem(new MagicApple());
        getLogger().info("Registered Magic Apple");
    }
}
