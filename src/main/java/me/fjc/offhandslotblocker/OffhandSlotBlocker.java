package me.fjc.offhandslotblocker;

import me.fjc.offhandslotblocker.listener.InvListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public class OffhandSlotBlocker extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InvListener(), this);
        if (getServer().getPluginManager().isPluginEnabled("MythicMobs")) {
            Bukkit.getLogger().info("Found MythicMobs!");

        } else {
            Bukkit.getLogger().warning("Could not find MythicMobs! That could be a problem");
            Bukkit.getLogger().warning("Registering events anyway.");
        }
        getLogger().info("Loading configuration..");
        createConfig();
        getLogger().info("Success.");

        Bukkit.getLogger().info("Everything has loaded, probably.");
    }
    public void onDisable() {
        getLogger().info("Shutting down.");
        saveConfig();
    }
    private void createConfig() {
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        configuration.addDefault("Target", Material.PIG_SPAWN_EGG);

    }
}
