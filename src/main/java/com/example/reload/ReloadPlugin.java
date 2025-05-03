package com.example.reload;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class ReloadPlugin extends JavaPlugin {
    private ConfigManager configManager;
    private BukkitTask task;

    @Override
    public void onEnable() {
        // 注册命令
        getCommand("ro").setExecutor(new CommandHandler(this));

        // 初始化配置
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        configManager = new ConfigManager(this);
        configManager.setupConfig();

        startCommandScheduler();
        getLogger().info("插件已启用！");
    }

    // 新增配置重载方法
    public void reloadPluginConfig() {
        configManager.setupConfig();
        if (task != null) {
            task.cancel();
        }
        startCommandScheduler();
        getLogger().info("配置已重新加载！");
    }
    @Override
    public void onDisable() {
        if (task != null) {
            task.cancel();
        }
        getLogger().info("ReloadPlugin 已禁用！");
    }

    private void startCommandScheduler() {
        long interval = configManager.getInterval() * 20L;
        task = getServer().getScheduler().runTaskTimer(this, () -> {
            for (String command : configManager.getCommands()) {
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                getLogger().info("已执行命令: " + command);
            }
        }, 0L, interval);
    }
}