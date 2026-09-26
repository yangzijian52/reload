# Reload

一个用于定时执行后台命令，并支持手动重载配置的 Paper 插件。

## 当前版本

- 插件版本：`1.0.3`
- Paper API：`26.3.build.41-alpha`
- Java 要求：`25+`

## 主要功能

- 按配置的时间间隔定时执行后台命令
- 支持通过 `/ro config` 重新加载配置
- 配置文件不存在时自动生成默认配置

## 运行要求

- Paper `26.3`
- Java `25+`

## 命令

- `/ro config`：重载插件配置
- 权限节点：`reload.command`

## 当前状态

- 已完成 `Paper 26.3` / `Java 25` 重编译，并通过测试服启动、重启和四服并联回归
- 已改为通过 Maven 进行标准构建
- 已完成本地构建验证
- 插件原有功能无需针对 `Paper 26.3` 进行额外适配

## 构建

```bash
mvn clean package
```

构建完成后可在 `target/` 目录获取插件 jar。

## SpigotMC 发布资料

- [SpigotMC 资源页面](https://www.spigotmc.org/resources/reload.137018/)
- [版本变更记录](CHANGELOG.md)
- [MIT License](LICENSE)
