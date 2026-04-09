# Reload

一个用于定时执行后台命令，并支持手动重载配置的 Paper 插件。

## 当前版本

- 插件版本：`1.0.1`
- Paper API：`26.1.1.build.20-alpha`
- Java 要求：`25+`

## 主要功能

- 按配置的时间间隔定时执行后台命令
- 支持通过 `/ro config` 重新加载配置
- 配置文件不存在时自动生成默认配置

## 运行要求

- Paper `26.1.x`
- Java `25+`

## 命令

- `/ro config`：重载插件配置
- 权限节点：`reload.command`

## 当前状态

- 已完成 `Paper 26.1` 与 `Java 25` 升级
- 已改为通过 Maven 进行标准构建
- 已完成本地构建验证
- 已完成 `Paper 26.1` 服内测试，当前运行正常

## 构建

```bash
mvn clean package
```

构建完成后可在 `target/` 目录获取插件 jar。
