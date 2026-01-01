package de.customitems.core.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import de.customitems.core.CustomItemsCore;

import java.util.List;

public abstract class CustomItem {

    private final String id;
    private final Material baseMaterial;
    private final String displayName;
    private final List<String> lore;
    private final int customModelData;

    public CustomItem(String id, Material baseMaterial, String displayName, List<String> lore, int customModelData) {
        this.id = id;
        this.baseMaterial = baseMaterial;
        this.displayName = displayName;
        this.lore = lore;
        this.customModelData = customModelData;
    }

    public String getId() {
        return id;
    }

    public Material getBaseMaterial() {
        return baseMaterial;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getLore() {
        return lore;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    /**
     * Creates the ItemStack for this custom item
     */
    public ItemStack create() {
        ItemStack item = new ItemStack(baseMaterial);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(displayName);
            meta.setLore(lore);

            if (customModelData > 0) {
                meta.setCustomModelData(customModelData);
            }

            // Store custom item ID in PersistentDataContainer
            NamespacedKey key = new NamespacedKey(CustomItemsCore.getInstance(), "custom_item_id");
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);

            item.setItemMeta(meta);
        }

        return item;
    }

    /**
     * Check if an ItemStack is this custom item
     */
    public static boolean isCustomItem(ItemStack item, String customId) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(CustomItemsCore.getInstance(), "custom_item_id");

        if (meta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            String storedId = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
            return customId.equals(storedId);
        }

        return false;
    }

    /**
     * Get the custom item ID from an ItemStack
     */
    public static String getCustomItemId(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return null;
        }

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(CustomItemsCore.getInstance(), "custom_item_id");

        return meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
    }
}
