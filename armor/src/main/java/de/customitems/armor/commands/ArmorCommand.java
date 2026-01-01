package de.customitems.armor.commands;

import de.customitems.core.items.CustomItem;
import de.customitems.core.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ArmorCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Command nutzen!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Verwendung: /armor <item_id>");
            return true;
        }

        String itemId = args[0];
        ItemManager manager = ItemManager.getInstance();

        Optional<CustomItem> customItemOpt = manager.getItem(itemId);

        if (customItemOpt.isEmpty()) {
            player.sendMessage(ChatColor.RED + "Armor-Item '" + itemId + "' wurde nicht gefunden!");
            return true;
        }

        CustomItem customItem = customItemOpt.get();
        player.getInventory().addItem(customItem.create());
        player.sendMessage(ChatColor.GREEN + "Du hast " + customItem.getDisplayName() + ChatColor.GREEN + " erhalten!");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            ItemManager manager = ItemManager.getInstance();
            return StreamSupport.stream(manager.getItemIds().spliterator(), false)
                    .filter(id -> id.toLowerCase().startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
