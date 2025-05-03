# Reload - Minecraft 定时指令执行插件

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.4-green.svg)](https://www.minecraft.net)
[![Java Version](https://img.shields.io/badge/Java-21-red.svg)](https://openjdk.org)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> 一个轻量级定时指令执行插件，支持配置热重载和跨版本运行

## ✨ 功能特性
- ⏰ **定时任务** - 可配置间隔时间（秒级精度）自动执行控制台指令
- 🔄 **热重载** - 支持通过 `/ro config` 命令实时重载配置
- 🔐 **权限控制** - 内置完整的权限管理系统
- 📝 **灵活配置** - 支持多指令顺序执行和动态调整
- 📊 **详细日志** - 所有操作均有控制台日志记录
- 🌐 **全版本兼容** - 支持 Minecraft 1.8+ 至最新版本

## 📦 安装
1. 下载最新版本 [Reload.jar](https://github.com/yangzijian/reload/releases)
2. 放入服务器 `plugins/` 目录
3. 重启服务器

## ⚙️ 配置示例
```yaml
plugins/Reload/config.yml

指令间隔时间（秒）
interval: 60

要执行的命令列表（按顺序执行）
commands:
  - say 服务器正常运行中
  - save-all
  - dynmap renderall
```  

## 📜 命令列表
命令	权限节点	描述
/ro config	reload.command	重载配置文件

## 🔑 权限系统
```yaml
# 默认权限配置
reload.command:
  description: 允许重载插件配置
  default: op # 默认仅OP可用
```
## 🛠️ 开发构建
```yaml
# 克隆仓库
git clone https://github.com/yourusername/reload.git

# 构建插件
mvn clean package
```

## ❓ 常见问题
Q：配置文件没有自动生成怎么办？
A：请检查服务器对 plugins/Reload/ 目录是否有写入权限

Q：指令没有执行？
A：检查间隔时间配置是否 ≥30 秒，并查看控制台日志

Q：如何添加危险指令保护？
A：在配置文件中避免使用 stop/reload 等危险指令

## 📄 开源协议
本项目采用 MIT License 开源

---

### 推荐搭配
- [PlaceholderAPI](https://github.com/PlaceholderAPI/PlaceholderAPI) - 变量支持
- [Vault](https://github.com/MilkBowl/Vault) - 经济系统集成

---

**Star ⭐ 本项目以获取最新更新！**  
[报告问题](https://github.com/yourusername/reload/issues) | [功能请求](https://github.com/yourusername/reload/discussions)
