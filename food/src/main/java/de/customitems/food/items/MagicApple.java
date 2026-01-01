package de.customitems.food.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;

public class MagicApple extends CustomFood {

    public MagicApple() {
        super(
            "magic_apple",                               // Unique ID
            Material.APPLE,                              // Base Material
            ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Magischer Apfel",
            Arrays.asList(
                ChatColor.GRAY + "Ein Apfel voller magischer Energie.",
                "",
                ChatColor.GREEN + "❤ Heilt 10 HP",
                ChatColor.AQUA + "⚡ Gibt Regeneration II (10s)",
                ChatColor.YELLOW + "✦ Gibt Speed II (15s)"
            ),
            1,                                           // Custom Model Data
            4,                                           // Hunger (2 Shanks)
            10.0f                                        // Saturation
        );
    }
}
