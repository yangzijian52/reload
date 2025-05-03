package com.example.reload;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
    private final ReloadPlugin plugin;

    public CommandHandler(ReloadPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("config")) {
            plugin.reloadPluginConfig();
            sender.sendMessage("§a配置重载成功！");
            return true;
        }
        sender.sendMessage("§e用法: /ro config");
        return false;
    }
}