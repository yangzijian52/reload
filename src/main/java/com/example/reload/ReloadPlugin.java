package com.example.reload;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class ReloadPlugin extends JavaPlugin {

    private ConfigManager configManager;
    private BukkitTask task;

    @Override
    public void onEnable() {
        getCommand("ro").setExecutor(new CommandHandler(this));

        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        configManager = new ConfigManager(this);
        configManager.setupConfig();

        startCommandScheduler();
        getLogger().info("Reload 插件已启用。");
    }

    @Override
    public void onDisable() {
        if (task != null) {
            task.cancel();
        }

        getLogger().info("Reload 插件已禁用。");
    }

    public void reloadPluginConfig() {
        configManager.setupConfig();

        if (task != null) {
            task.cancel();
        }

        startCommandScheduler();
        getLogger().info("配置已重新加载。");
    }

    private void startCommandScheduler() {
        long interval = Math.max(1L, configManager.getInterval()) * 20L;
        task = getServer().getScheduler().runTaskTimer(this, () -> {
            for (String command : configManager.getCommands()) {
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                getLogger().info("已执行命令: " + command);
            }
        }, 0L, interval);
    }
}
