package de.customitems.weapons.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;

public class FlamesSword extends CustomWeapon {

    public FlamesSword() {
        super(
            "flames_sword",                              // Unique ID
            Material.DIAMOND_SWORD,                      // Base Material
            ChatColor.RED + "" + ChatColor.BOLD + "Flammenschwert",  // Display Name
            Arrays.asList(                               // Lore
                ChatColor.GRAY + "Ein legendäres Schwert,",
                ChatColor.GRAY + "das in Flammen gehüllt ist.",
                "",
                ChatColor.RED + "⚔ Schaden: 12",
                ChatColor.GOLD + "🔥 Setzt Gegner in Brand"
            ),
            1,                                           // Custom Model Data (für Texturen)
            12.0,                                        // Damage
            1.6                                          // Attack Speed
        );
    }
}
