package de.customitems.food.listeners;

import de.customitems.core.items.CustomItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FoodListener implements Listener {

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Get custom item ID
        String customId = CustomItem.getCustomItemId(item);
        if (customId == null) {
            return;
        }

        // Handle Magic Apple
        if (customId.equals("magic_apple")) {
            handleMagicApple(player);
        }
    }

    private void handleMagicApple(Player player) {
        // Instant healing
        player.setHealth(Math.min(player.getHealth() + 10.0, player.getMaxHealth()));

        // Regeneration II for 10 seconds
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));

        // Speed II for 15 seconds
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
    }
}
