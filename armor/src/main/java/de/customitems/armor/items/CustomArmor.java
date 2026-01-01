package de.customitems.armor.items;

import de.customitems.core.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;

public class CustomArmor extends CustomItem {

    private final EquipmentSlot slot;
    private final double armor;
    private final double toughness;

    public CustomArmor(String id, Material baseMaterial, String displayName,
                      List<String> lore, int customModelData,
                      EquipmentSlot slot, double armor, double toughness) {
        super(id, baseMaterial, displayName, lore, customModelData);
        this.slot = slot;
        this.armor = armor;
        this.toughness = toughness;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public double getArmor() {
        return armor;
    }

    public double getToughness() {
        return toughness;
    }
}
