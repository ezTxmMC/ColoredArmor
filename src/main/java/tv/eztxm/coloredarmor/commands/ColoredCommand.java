package tv.eztxm.coloredarmor.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tv.eztxm.coloredarmor.ColoredArmor;
import tv.eztxm.coloredarmor.utils.FileManager;

public class ColoredCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (!player.hasPermission("colored.use")) player.sendMessage(ColoredArmor.getPrefix() + FileManager.getNoPermsString());
        else {
            if (args.length == 4) {
                switch (args[0]) {
                    case "helmet":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_HELMET,
                                Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                        break;
                    case "chestplate":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_CHESTPLATE,
                                Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                        break;
                    case "leggings":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_LEGGINGS,
                                Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                        break;
                    case "boots":
                        player.getInventory().addItem(ColoredArmor.createColored(Material.LEATHER_BOOTS,
                                Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                        break;
                    default:
                        player.sendMessage(ColoredArmor.getPrefix() + FileManager.getColoredCommand());
                        break;
                }
            } else {
                player.sendMessage(ColoredArmor.getPrefix() + FileManager.getColoredCommand());
            }
        }
        return true;
    }
}
