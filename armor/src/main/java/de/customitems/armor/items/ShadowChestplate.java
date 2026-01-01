package de.customitems.armor.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Arrays;

public class ShadowChestplate extends CustomArmor {

    public ShadowChestplate() {
        super(
            "shadow_chestplate",                         // Unique ID
            Material.NETHERITE_CHESTPLATE,               // Base Material
            ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Schatten-Brustplatte",
            Arrays.asList(
                ChatColor.GRAY + "Eine Rüstung aus reiner Dunkelheit.",
                "",
                ChatColor.BLUE + "⛨ Rüstung: 8",
                ChatColor.AQUA + "◈ Härte: 3",
                ChatColor.DARK_PURPLE + "👁 Gibt Nachtsicht",
                ChatColor.LIGHT_PURPLE + "💨 Gibt Speed I"
            ),
            1,                                           // Custom Model Data
            EquipmentSlot.CHEST,                         // Equipment Slot
            8.0,                                         // Armor
            3.0                                          // Toughness
        );
    }
}
