package dev.eztxm.coloredarmor.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import dev.eztxm.coloredarmor.ColoredArmor;
import dev.eztxm.coloredarmor.util.FileManager;

import java.util.Collections;
import java.util.List;

public class ArmorcolorCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("colored.use")) player.sendMessage(ColoredArmor.getPrefix() + FileManager.getNoPermsString());
        else {
            if (args.length == 2) {
                switch (args[1]) {
                    case "helmet":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_HELMET, args[0]));
                        break;
                    case "chestplate":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_CHESTPLATE, args[0]));
                        break;
                    case "leggings":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_LEGGINGS, args[0]));
                        break;
                    case "boots":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_BOOTS, args[0]));
                        break;
                    case "all":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_HELMET, args[0]));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_CHESTPLATE, args[0]));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_LEGGINGS, args[0]));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_BOOTS, args[0]));
                        break;
                    default:
                        player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
                        break;
                }
                return false;
            }
            if (args.length == 4) {
                switch (args[3]) {
                    case "helmet":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_HELMET,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        break;
                    case "chestplate":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_CHESTPLATE,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        break;
                    case "leggings":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_LEGGINGS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        break;
                    case "boots":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_BOOTS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        break;
                    case "all":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_HELMET,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_CHESTPLATE,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_LEGGINGS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_BOOTS,
                                Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        break;
                    default:
                        player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
                        break;
                }
                return false;
            }
            player.sendMessage(ColoredArmor.getPrefix().split(" ")[0] + "\n" + FileManager.getColoredCommand() + "\n" + ColoredArmor.getPrefix().split(" ")[0]);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
