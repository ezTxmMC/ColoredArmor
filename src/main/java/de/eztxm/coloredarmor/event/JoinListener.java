package de.eztxm.coloredarmor.event;

import de.eztxm.coloredarmor.util.FileManager;
import de.eztxm.coloredarmor.ColoredArmor;
import de.eztxm.coloredarmor.util.UpdateChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("colored.update")) {
            if (!new UpdateChecker(ColoredArmor.getInstance().getDescription().getVersion()).latestVersion()) {
                player.sendMessage(ColoredArmor.getPrefix() + FileManager.getUpdateString());
            }
        }
    }
}
