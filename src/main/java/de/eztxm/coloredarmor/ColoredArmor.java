package de.eztxm.coloredarmor;

import com.github.lalyos.jfiglet.FigletFont;
import de.eztxm.coloredarmor.command.ColoredArmorCommand;
import de.eztxm.coloredarmor.event.JoinListener;
import de.eztxm.coloredarmor.util.FileManager;
import org.bukkit.Bukkit;
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
