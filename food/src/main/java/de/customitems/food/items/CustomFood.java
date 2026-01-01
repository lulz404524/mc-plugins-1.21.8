package de.customitems.food.items;

import de.customitems.core.items.CustomItem;
import org.bukkit.Material;

import java.util.List;

public class CustomFood extends CustomItem {

    private final int hunger;
    private final float saturation;

    public CustomFood(String id, Material baseMaterial, String displayName,
                     List<String> lore, int customModelData,
                     int hunger, float saturation) {
        super(id, baseMaterial, displayName, lore, customModelData);
        this.hunger = hunger;
        this.saturation = saturation;
    }

    public int getHunger() {
        return hunger;
    }

    public float getSaturation() {
        return saturation;
    }
}
