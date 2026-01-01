package de.customitems.tools.listeners;

import de.customitems.core.items.CustomItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class ToolListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack tool = player.getInventory().getItemInMainHand();

        String customId = CustomItem.getCustomItemId(tool);
        if (customId == null) {
            return;
        }

        // Handle Drill Pickaxe
        if (customId.equals("drill_pickaxe")) {
            handleDrillPickaxe(event, player);
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        ItemStack item = event.getItem();
        String customId = CustomItem.getCustomItemId(item);

        if (customId == null) {
            return;
        }

        // Drill Pickaxe is unbreakable
        if (customId.equals("drill_pickaxe")) {
            event.setCancelled(true);
        }
    }

    private void handleDrillPickaxe(BlockBreakEvent event, Player player) {
        Block centerBlock = event.getBlock();
        Location centerLoc = centerBlock.getLocation();

        // Break 3x3 area
        Set<Block> blocksToBreak = new HashSet<>();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Block block = centerLoc.clone().add(x, y, z).getBlock();

                    // Only break mineable blocks
                    if (block.getType() != Material.AIR &&
                        block.getType() != Material.BEDROCK &&
                        !block.isLiquid()) {
                        blocksToBreak.add(block);
                    }
                }
            }
        }

        // Break all blocks
        for (Block block : blocksToBreak) {
            if (!block.equals(centerBlock)) {
                block.breakNaturally(player.getInventory().getItemInMainHand());
            }
        }
    }
}
