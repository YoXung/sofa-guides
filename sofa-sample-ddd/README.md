## 快速入门

本文档将演示如何在 SOFABoot 环境下基于COLA进行DDD开发，本项目一共包括六个模块：

```text
sofa-sample-ddd
│
├── sofa-sample-ddd-bootstrap 
│ 
├── sofa-sample-ddd-adapter
│ 
├── sofa-sample-ddd-facade
│ 
├── sofa-sample-ddd-client 
│ 
├── sofa-sample-ddd-application
│ 
├── sofa-sample-ddd-domain 
│ 
└── sofa-sample-ddd-infrastructure 
│   ├── sofa-sample-ddd-repository
│   ├── sofa-sample-ddd-mq
│   ├── sofa-sample-ddd-cache
│   └── sofa-sample-ddd-search
```
各个模块的作用如下：

- sofa-sample-ddd-bootstrap: 启动包含 SOFABoot 模块的 SOFA Boot 应用；
- sofa-sample-ddd-adapter: 演示 JVM 服务发布与引用的 API 包；
- sofa-sample-isle-provider: 演示 XML 方式、Annotation 方式、API 方式发布 JVM 服务；
- sofa-sample-isle-bootstrap: 