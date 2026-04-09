package com.example.reload;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigManager {

    private final JavaPlugin plugin;
    private FileConfiguration config;
    private final File configFile;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    public void setupConfig() {
        try {
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdirs();
            }

            if (!configFile.exists()) {
                plugin.saveResource("config.yml", false);
                plugin.getLogger().info("已创建默认配置文件。");
            }

            reloadConfig();
        } catch (Exception e) {
            plugin.getLogger().severe("配置文件初始化失败: " + e.getMessage());
            config = new YamlConfiguration();
        }
    }

    public void reloadConfig() {
        try {
            config = YamlConfiguration.loadConfiguration(configFile);
            plugin.getLogger().info("配置文件已从 " + configFile.getPath() + " 重新加载。");
        } catch (Exception e) {
            plugin.getLogger().severe("配置文件重载失败: " + e.getMessage());
            config = new YamlConfiguration();
        }
    }

    public int getInterval() {
        return config.getInt("interval", 300);
    }

    public List<String> getCommands() {
        return config.getStringList("commands");
    }

    public void saveConfig() {
        try {
            config.save(configFile);
            plugin.getLogger().info("配置修改已保存。");
        } catch (IOException e) {
            plugin.getLogger().severe("配置保存失败: " + e.getMessage());
        }
    }
}
