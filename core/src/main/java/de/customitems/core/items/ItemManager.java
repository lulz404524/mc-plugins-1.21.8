package de.customitems.core.items;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemManager {

    private static ItemManager instance;
    private final Map<String, CustomItem> registeredItems = new HashMap<>();

    private ItemManager() {}

    public static ItemManager getInstance() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    /**
     * Register a custom item
     */
    public void registerItem(CustomItem item) {
        registeredItems.put(item.getId(), item);
    }

    /**
     * Get a custom item by ID
     */
    public Optional<CustomItem> getItem(String id) {
        return Optional.ofNullable(registeredItems.get(id));
    }

    /**
     * Get all registered item IDs
     */
    public Iterable<String> getItemIds() {
        return registeredItems.keySet();
    }

    /**
     * Check if an item is registered
     */
    public boolean isRegistered(String id) {
        return registeredItems.containsKey(id);
    }
}
