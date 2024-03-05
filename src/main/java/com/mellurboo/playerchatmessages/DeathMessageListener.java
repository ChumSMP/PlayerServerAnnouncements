package com.mellurboo.playerchatmessages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class DeathMessageListener implements Listener {

    private final JavaPlugin plugin;

    public DeathMessageListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        FileConfiguration config = plugin.getConfig();
        List<String> deathMessages = config.getStringList("deathMessages");
        String cause = event.getDeathMessage();
        event.deathMessage(null);
        String message = getRandomMessage(deathMessages).replace("%cause%", "(" + cause + ")");
        Bukkit.broadcastMessage(message.replace("%player%", event.getEntity().getName()));
    }

    private String getRandomMessage(List<String> messages) {
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }
}

