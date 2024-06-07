package de.eztxm.coloredarmor.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemUtil {

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
}
