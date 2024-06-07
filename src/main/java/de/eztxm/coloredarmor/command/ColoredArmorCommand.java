package de.eztxm.coloredarmor.command;

import de.eztxm.coloredarmor.util.FileManager;
import de.eztxm.coloredarmor.util.ItemUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import de.eztxm.coloredarmor.ColoredArmor;

import java.util.Collections;
import java.util.List;

public class ColoredArmorCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (player.hasPermission("colored.use")) {
            if (args.length == 2) {
                switch (args[1]) {
                    case "helmet":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_HELMET, args[0]));
                        return true;
                    case "chestplate":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_CHESTPLATE, args[0]));
                        return true;
                    case "leggings":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_LEGGINGS, args[0]));
                        return true;
                    case "boots":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_BOOTS, args[0]));
                        return true;
                    case "all":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_HELMET, args[0]));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_CHESTPLATE, args[0]));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_LEGGINGS, args[0]));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_BOOTS, args[0]));
                        return true;
                    default:
                        player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
                        return true;
                }
            }
            if (args.length == 4) {
                switch (args[3]) {
                    case "helmet":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_HELMET,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        return true;
                    case "chestplate":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_CHESTPLATE,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        return true;
                    case "leggings":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_LEGGINGS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        return true;
                    case "boots":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_BOOTS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        return true;
                    case "all":
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_HELMET,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_CHESTPLATE,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_LEGGINGS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ItemUtil.createColored(Material.LEATHER_BOOTS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        return true;
                    default:
                        player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
                        return true;
                }
            }
            player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
            return false;
        }
        player.sendMessage(ColoredArmor.getPrefix() + FileManager.getNoPermsString());
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
