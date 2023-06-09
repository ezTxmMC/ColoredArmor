package dev.eztxm.coloredarmor;

import com.github.lalyos.jfiglet.FigletFont;
import dev.eztxm.coloredarmor.command.ArmorcolorCommand;
import dev.eztxm.coloredarmor.util.FileManager;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class ColoredArmor extends JavaPlugin {
    private static ColoredArmor instance;
    private static String prefix;

    @Override
    public void onEnable() {
        FileManager fileManager = new FileManager();
        fileManager.setup();
        getCommand("armorcolor").setExecutor(new ArmorcolorCommand());
        try {
            System.out.println("\n" + FigletFont.convertOneLine("ColoredArmor") + "\nby ezTxmMC      Version: 1.3\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ItemStack createColored(Material material, String hex) {
        if (!hex.substring(0, 1).equalsIgnoreCase("#")) {
            hex = "#" + hex;
        }
        String replacedHex = hex.replace("#","0x");
        ItemStack itemStack = new ItemStack(material);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        itemMeta.setColor(Color.fromRGB(Integer.decode(replacedHex)));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createColored(Material material, int red, int green, int blue) {
        ItemStack itemStack = new ItemStack(material);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        itemMeta.setColor(Color.fromRGB(red, green, blue));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static void setPrefix(String prefix) {
        ColoredArmor.prefix = prefix;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static ColoredArmor getInstance() {
        return instance;
    }
}
