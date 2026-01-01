package de.customitems.armor.listeners;

import de.customitems.core.CustomItemsCore;
import de.customitems.core.items.CustomItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ArmorListener implements Listener {

    private final Set<UUID> playersWithEffects = new HashSet<>();

    public ArmorListener() {
        // Check armor effects every 2 seconds
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : CustomItemsCore.getInstance().getServer().getOnlinePlayers()) {
                    checkArmorEffects(player);
                }
            }
        }.runTaskTimer(CustomItemsCore.getInstance(), 0L, 40L);
    }

    private void checkArmorEffects(Player player) {
        ItemStack chestplate = player.getInventory().getChestplate();

        if (chestplate == null) {
            playersWithEffects.remove(player.getUniqueId());
            return;
        }

        String customId = CustomItem.getCustomItemId(chestplate);

        // Check for Shadow Chestplate
        if ("shadow_chestplate".equals(customId)) {
            applyShadowChestplateEffects(player);
            playersWithEffects.add(player.getUniqueId());
        } else {
            playersWithEffects.remove(player.getUniqueId());
        }
    }

    private void applyShadowChestplateEffects(Player player) {
        // Night Vision
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0, true, false));

        // Speed I
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0, true, false));
    }
}
