package dev.eztxm.coloredarmor.util;

import org.bukkit.configuration.file.YamlConfiguration;
import dev.eztxm.coloredarmor.ColoredArmor;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private static final File folder = new File("plugins/ColoredArmor");
    private static final File folderLang = new File("plugins/ColoredArmor/language");
    private static final File config = new File("plugins/ColoredArmor/config.yml");
    private static final File langDE = new File("plugins/ColoredArmor/language/de_DE.yml");
    private static final File langEN = new File("plugins/ColoredArmor/language/en_US.yml");
    private static final File langFR = new File("plugins/ColoredArmor/language/fr_FR.yml");
    private static final YamlConfiguration configYaml = YamlConfiguration.loadConfiguration(config);
    private static final YamlConfiguration de_DEYaml = YamlConfiguration.loadConfiguration(langDE);
    private static final YamlConfiguration en_USYaml = YamlConfiguration.loadConfiguration(langEN);
    private static final YamlConfiguration fr_FRYaml = YamlConfiguration.loadConfiguration(langFR);

    private void save() {
        try {
            configYaml.save(config);
            de_DEYaml.save(langDE);
            en_USYaml.save(langEN);
            fr_FRYaml.save(langFR);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ColoredArmor.setPrefix(configYaml.getString("Prefix").replace('&', '§'));
    }

    public void setup() {
        if (!folder.exists())
            folder.mkdir();
        if (!folderLang.exists())
            folderLang.mkdir();
        try {
            if (!config.exists()) {
                config.createNewFile();
            }
            if (!langDE.exists()) {
                langDE.createNewFile();
            }
            if (!langEN.exists()) {
                langEN.createNewFile();
            }
            if (!langFR.exists()) {
                langFR.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        configYaml.addDefault("Prefix", "&a&lColoredArmor &8| &7");
        configYaml.addDefault("Language", "en_US");
        configYaml.options().copyDefaults(true);
        de_DEYaml.addDefault("Messages.Keine-Rechte", "&cKeine Rechte");
        en_USYaml.addDefault("Messages.No-Perms", "&cNo Perms");
        fr_FRYaml.addDefault("Messages.Pas-de-permissions", "&cPas de permissions");
        de_DEYaml.addDefault("Messages.Befehl", "&7/armorcolor <red> <green> <blue> <helmet|chestplate|leggings|boots>\n&7/armorcolor <hex> <piece>");
        en_USYaml.addDefault("Messages.Command", "&7/armorcolor <red> <green> <blue> <helmet|chestplate|leggings|boots>\n&7/armorcolor <hex> <piece>");
        fr_FRYaml.addDefault("Messages.Commande", "&7/armorcolor <red> <green> <blue> <helmet|chestplate|leggings|boots>\n&7/armorcolor <hex> <piece>");
        de_DEYaml.options().copyDefaults(true);
        en_USYaml.options().copyDefaults(true);
        fr_FRYaml.options().copyDefaults(true);
        save();
    }

    public static String getNoPermsString() {
        if (configYaml.getString("Language").equals("de_DE")) {
            return de_DEYaml.getString("Messages.Keine-Rechte").replace('&', '§');
        }
        if (configYaml.getString("Language").equals("fr_FR")) {
            return fr_FRYaml.getString("Messages.Pas-de-permissions").replace('&', '§');
        }
        return en_USYaml.getString("Messages.No-Perms").replace('&', '§');
    }

    public static String getColoredCommand() {
        if (configYaml.getString("Language").equals("de_DE")) {
            return de_DEYaml.getString("Messages.Befehl").replace('&', '§');
        }
        if (configYaml.getString("Language").equals("fr_FR")) {
            return fr_FRYaml.getString("Messages.Commande").replace('&', '§');
        }
        return en_USYaml.getString("Messages.Command").replace('&', '§');
    }
}
