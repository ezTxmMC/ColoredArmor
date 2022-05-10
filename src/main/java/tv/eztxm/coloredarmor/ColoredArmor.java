package tv.eztxm.coloredarmor;

import com.github.lalyos.jfiglet.FigletFont;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import tv.eztxm.coloredarmor.commands.ColoredCommand;
import tv.eztxm.coloredarmor.utils.FileManager;

import java.io.IOException;

public class ColoredArmor extends JavaPlugin {
    private static String prefix;

    @Override
    public void onEnable() {
        FileManager fileManager = new FileManager();
        fileManager.setup();
        getCommand("colored").setExecutor(new ColoredCommand());
        try {
            System.out.println("\n" + FigletFont.convertOneLine("ColoredArmor") + "\nby ezTxmMC      Version: 1.1\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
