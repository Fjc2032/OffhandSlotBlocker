package me.Fjc.PigOffhandBlocker;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginStartup extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PigOffhandBlocker(), this);
        getLogger().info("Fj's plugin PigOffhandBlocker has been enabled!");
        //When the plugin is enabled, these methods are called
    }

    @Override
    public void onDisable() {

    }

    {
        getLogger().info("PigOffhandBlocker was disabled. Server most likely shutting down.");
        //The plugin sends this message to the console when it is shut down
    }
}
