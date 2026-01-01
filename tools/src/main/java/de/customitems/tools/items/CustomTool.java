package de.customitems.tools.items;

import de.customitems.core.items.CustomItem;
import org.bukkit.Material;

import java.util.List;

public class CustomTool extends CustomItem {

    private final double efficiency;
    private final int durability;

    public CustomTool(String id, Material baseMaterial, String displayName,
                     List<String> lore, int customModelData,
                     double efficiency, int durability) {
        super(id, baseMaterial, displayName, lore, customModelData);
        this.efficiency = efficiency;
        this.durability = durability;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public int getDurability() {
        return durability;
    }
}
