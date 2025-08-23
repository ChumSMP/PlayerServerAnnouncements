package com.mellurboo.playerchatmessages;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class JoinMessageListener implements Listener {

    private final JavaPlugin plugin;

    public JoinMessageListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = plugin.getConfig();
        List<String> joinMessages = config.getStringList("joinMessages");
        String message = getRandomMessage(joinMessages);
        Bukkit.broadcastMessage(message.replace("%player%", event.getPlayer().getName()));
    }

    private String getRandomMessage(List<String> messages) {
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}

