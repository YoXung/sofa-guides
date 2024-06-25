# 如何在 SOFABoot 环境中使用 SOFARPC

## 简介
该用例工程演示如何在 SOFABoot 环境中使用 SOFARPC，阅读该文档之前，建议先了解 [SOFARPC](https://github.com/sofastack/sofa-rpc)
在本地启动Zookeeper

在运行本示例工程之前，需要先在本地启动一个 Zookeeper 服务端。
## 使用 Zookeeper 作为注册中心
在 application.properties 中配置如下，就能够使用 Zookeeper 作为注册中心。
```
com.alipay.sofa.rpc.registry.address=zookeeper://127.0.0.1:2181
```
## 引入 SOFARPC Starter
SOFARPC Starter 是 SOFARPC 基于 SOFABoot 实现的框架，能够将 SOFARPC 的能力以统一的编程界面和简单的操作形式提供给使用者。该依赖已被 SOFABoot 管控，用户只需要引入如下依赖：
```xml
<dependency>
     <groupId>com.alipay.sofa</groupId>
     <artifactId>rpc-sofa-boot-starter</artifactId>
 </dependency>
```