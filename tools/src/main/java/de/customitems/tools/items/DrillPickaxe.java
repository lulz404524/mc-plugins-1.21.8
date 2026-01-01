package de.customitems.tools.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;

public class DrillPickaxe extends CustomTool {

    public DrillPickaxe() {
        super(
            "drill_pickaxe",                             // Unique ID
            Material.NETHERITE_PICKAXE,                  // Base Material
            ChatColor.GOLD + "" + ChatColor.BOLD + "Bohrer-Spitzhacke",
            Arrays.asList(
                ChatColor.GRAY + "Eine mechanische Spitzhacke,",
                ChatColor.GRAY + "die Blöcke im Nu zerstört.",
                "",
                ChatColor.AQUA + "⚡ Effizienz: Haste III",
                ChatColor.YELLOW + "💎 Baut 3x3 Bereich ab",
                ChatColor.GREEN + "♾ Unendliche Haltbarkeit"
            ),
            1,                                           // Custom Model Data
            15.0,                                        // Efficiency (Haste level)
            -1                                           // Durability (-1 = unbreakable)
        );
    }
}
