package com.mellurboo.playerchatmessages;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerChatMessages extends JavaPlugin implements Listener {
    public SendTimerChatMessage tcm = new SendTimerChatMessage(this);

    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinMessageListener(this), this);
        getServer().getPluginManager().registerEvents(new LeaveMessageListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathMessageListener(this), this);

        tcm.MapTimerMessages();
    }
}
