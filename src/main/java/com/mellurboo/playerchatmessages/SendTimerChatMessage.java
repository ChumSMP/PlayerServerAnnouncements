package com.mellurboo.playerchatmessages;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Map;

public class SendTimerChatMessage {
    private final PlayerChatMessages plugin;
    public SendTimerChatMessage(PlayerChatMessages plugin) { this.plugin = plugin; }

    public void MapTimerMessages(){
        List<Map<?, ?>> messages = plugin.getConfig().getMapList("messages");

        for (Map<?, ?> mdata : messages) {
            String message = (String) mdata.get("message");
            int interval = (int) mdata.get("interval");

            new BukkitRunnable(){
                @Override
                public void run(){
                    Bukkit.broadcastMessage(message);
                }
            }.runTaskTimer(plugin, interval * 20L, interval * 20L);

            Bukkit.getLogger().info(message + " has been set to send every " + interval + " seconds");
        }
    }
}
