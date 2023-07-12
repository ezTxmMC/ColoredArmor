package dev.eztxm.coloredarmor.event;

import dev.eztxm.coloredarmor.ColoredArmor;
import dev.eztxm.coloredarmor.util.FileManager;
import dev.eztxm.coloredarmor.util.UpdateChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("colored.update")) {
            new UpdateChecker(ColoredArmor.getInstance(), 99692).getVersion(version -> {
                if (!ColoredArmor.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                    player.sendMessage(ColoredArmor.getPrefix() + FileManager.getUpdateString());
                }
            });
        }
    }
}
