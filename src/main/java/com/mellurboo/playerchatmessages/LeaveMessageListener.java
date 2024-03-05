package com.mellurboo.playerchatmessages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class LeaveMessageListener implements Listener {

    private final JavaPlugin plugin;

    public LeaveMessageListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        FileConfiguration config = plugin.getConfig();
        List<String> leaveMessages = config.getStringList("leaveMessages");
        String message = getRandomMessage(leaveMessages);
        Bukkit.broadcastMessage(message.replace("%player%", event.getPlayer().getName()));
    }

    private String getRandomMessage(List<String> messages) {
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}
