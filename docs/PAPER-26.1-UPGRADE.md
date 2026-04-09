# Reload Paper 26.1 升级说明

## 概要

本文档记录 `Reload` 对 `Paper 26.1` 的兼容升级情况。

- 项目版本：`1.0.1`
- 目标 Paper API：`26.1.1.build.20-alpha`
- 所需 Java 版本：`25+`
- 升级日期：`2026-04-09`

## 本次调整

- `spigot-api 1.21.4-R0.1-SNAPSHOT` 升级为 `paper-api 26.1.1.build.20-alpha`
- Java 编译目标从 `21` 升级到 `25`
- `plugin.yml` 改为自动读取 Maven 版本
- 修正源码和默认配置中的中文乱码
- 补充中文 README 与升级说明文档

## 说明

- 截至 `2026-04-09`，PaperMC Maven 中 `paper-api` 的 `latest` 和 `release` 仍指向 `26.1.1.build.20-alpha`
- 当前已经完成本地构建验证
- 当前还没有完成服内功能测试，因此暂时不能标记为正式可用

## 验证建议

1. 使用 `Java 25` 运行 `mvn clean package`
2. 在 `Paper 26.1` 服务端测试定时命令执行
3. 测试 `/ro config` 是否能正确重载配置
