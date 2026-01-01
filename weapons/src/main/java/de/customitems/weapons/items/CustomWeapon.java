package de.customitems.weapons.items;

import de.customitems.core.items.CustomItem;
import org.bukkit.Material;

import java.util.List;

public class CustomWeapon extends CustomItem {

    private final double damage;
    private final double attackSpeed;

    public CustomWeapon(String id, Material baseMaterial, String displayName,
                       List<String> lore, int customModelData,
                       double damage, double attackSpeed) {
        super(id, baseMaterial, displayName, lore, customModelData);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public double getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }
}
