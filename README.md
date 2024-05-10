
# SOFAstack Learning
[![java](https://img.shields.io/badge/Java-17.0.11-F80000?logo=oracle)](https://www.oracle.com/cn/java/technologies/downloads/)
[![maven](https://img.shields.io/badge/Apache_Maven-3.9.6-C71A36?logo=apachemaven)](https://maven.apache.org/download.cgi)

[![sofa](https://img.shields.io/badge/SOFAStack-4.0.0-1677FF?logo=Alipay)](https://www.sofastack.tech)
[![springboot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?logo=springboot)](https://spring.io/projects/spring-boot#learn)

### 依赖管理
<table>
    <tr>
        <th colspan="2">中间件</th>
        <th>artifactId</th>
    </tr>
    <tr>
        <td rowspan="2">开发框架</td>
        <td>开源版</td>
        <td>sofaboot-dependencies</td>
    </tr>
    <tr>
        <td>商业版</td>
        <td>sofaboot-enterprise-dependencies </td>
    </tr>
    <tr>
        <td rowspan="3">微服务</td>
        <td>服务调用</td>
        <td>rpc-sofa-boot-starter</td>
    </tr>
    <tr>
        <td>动态配置</td>
        <td>ddcs-enterprise-sofa-boot-starter</td>
    </tr>
    <tr>
        <td>限流熔断</td>
        <td>guardian-sofa-boot-starter</td>
    </tr>
    <tr>
        <td colspan="2">健康检查</td>
        <td>actuator-sofa-boot-starter</td>
    </tr>
    <tr>
        <td colspan="2">模块隔离</td>
        <td>isle-sofa-boot-starter</td>
    </tr>
    <tr>
        <td colspan="2">任务调度</td>
        <td>scheduler-enterprise-sofa-boot-starter</td>
    </tr>
    <tr>
        <td colspan="2">消息队列</td>
        <td>sofamq-enterprise-sofa-boot-starter</td>
    </tr>
    <tr>
        <td colspan="2">分布式链路跟踪</td>
        <td>tracer-sofa-boot-starter</td>
    </tr>
    <tr>
        <td>分布式事务</td>
        <td>商业版</td>
        <td>dtx-enterprise-sofa-boot-starter</td>
    </tr>
</table>

### 工程结构
```
sofa-sample 
├── sofa-sample-gateway 
├── sofa-sample-ddd 
├── sofa-sample-rpc 
|   ├── sofa-sample-rpc-client     
|   ├── sofa-sample-rpc-facade
|   ├── sofa-sample-rpc-server
├── sofa-sample-isle 
|   ├── sofa-sample-isle-consumer     
|   ├── sofa-sample-isle-facade
|   ├── sofa-sample-isle-provider
|   └── sofa-sample-isle-run
├── sofa-sample-registry 
|   ├── sofa-sample-registry-client     
|   └── sofa-sample-registry-server
└──
```