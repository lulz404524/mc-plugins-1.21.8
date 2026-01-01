package de.customitems.weapons.listeners;

import de.customitems.core.items.CustomItem;
import de.customitems.weapons.items.CustomWeapon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class WeaponListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        // Check if attacker is a player
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack weapon = player.getInventory().getItemInMainHand();

        // Get custom item ID
        String customId = CustomItem.getCustomItemId(weapon);
        if (customId == null) {
            return;
        }

        // Handle Flames Sword
        if (customId.equals("flames_sword")) {
            handleFlamesSword(event, player);
        }
    }

    private void handleFlamesSword(EntityDamageByEntityEvent event, Player player) {
        // Set victim on fire for 5 seconds
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity victim = (LivingEntity) event.getEntity();
            victim.setFireTicks(100); // 100 ticks = 5 seconds

            // Increase damage
            event.setDamage(12.0);
        }
    }
}
