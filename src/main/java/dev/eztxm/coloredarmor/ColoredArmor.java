package dev.eztxm.coloredarmor;

import com.github.lalyos.jfiglet.FigletFont;
import dev.eztxm.coloredarmor.command.ColoredArmorCommand;
import dev.eztxm.coloredarmor.event.JoinListener;
import dev.eztxm.coloredarmor.util.FileManager;
import org.bukkit.Bukkit;
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
        instance = this;
        FileManager fileManager = new FileManager();
        fileManager.setup();
        getCommand("coloredarmor").setExecutor(new ColoredArmorCommand());
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        try {
            System.out.println("\n" + FigletFont.convertOneLine("ColoredArmor") + "\nby ezTxmMC      Version: \n" + getDescription().getVersion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        instance = null;
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
