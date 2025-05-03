package com.example.reload;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ConfigManager {
    private final JavaPlugin plugin;
    private FileConfiguration config;
    private final File configFile;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        // 指定配置文件路径：插件目录/config.yml
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
    }

    /**
     * 初始化配置文件
     */
    public void setupConfig() {
        try {
            // 确保插件目录存在
            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdirs();
            }

            // 如果配置文件不存在，从JAR中复制默认配置
            if (!configFile.exists()) {
                plugin.saveResource("config.yml", false);
                plugin.getLogger().info("已创建默认配置文件");
            }

            reloadConfig();
        } catch (Exception e) {
            plugin.getLogger().severe("配置文件初始化失败: " + e.getMessage());
            // 创建空配置防止崩溃
            config = new YamlConfiguration();
        }
    }

    /**
     * 重新加载配置文件
     */
    public void reloadConfig() {
        try {
            config = YamlConfiguration.loadConfiguration(configFile);
            plugin.getLogger().info("配置文件已从 " + configFile.getPath() + " 重新加载");
        } catch (Exception e) {
            plugin.getLogger().severe("配置文件重载失败: " + e.getMessage());
            config = new YamlConfiguration();
        }
    }

    /**
     * 获取命令执行间隔（秒）
     */
    public int getInterval() {
        // 默认值300秒（5分钟）
        return config.getInt("interval", 300);
    }

    /**
     * 获取要执行的命令列表
     */
    public List<String> getCommands() {
        // 默认返回空列表防止NPE
        return config.getStringList("commands");
    }

    /**
     * 保存配置修改（可选功能）
     */
    public void saveConfig() {
        try {
            config.save(configFile);
            plugin.getLogger().info("配置修改已保存");
        } catch (IOException e) {
            plugin.getLogger().severe("配置保存失败: " + e.getMessage());
        }
    }
}