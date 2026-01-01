package de.customitems.tools;

import de.customitems.core.items.ItemManager;
import de.customitems.tools.commands.ToolCommand;
import de.customitems.tools.items.DrillPickaxe;
import de.customitems.tools.listeners.ToolListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsTools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register custom tools
        registerTools();

        // Register commands
        getCommand("tool").setExecutor(new ToolCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new ToolListener(), this);

        getLogger().info("CustomItems-Tools has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomItems-Tools has been disabled!");
    }

    private void registerTools() {
        ItemManager manager = ItemManager.getInstance();
        manager.registerItem(new DrillPickaxe());
        getLogger().info("Registered Drill Pickaxe");
    }
}
