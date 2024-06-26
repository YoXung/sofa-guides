## 快速入门

本文档将演示如何在 SOFABoot 环境下进行模块化开发，本项目一共包括四个模块：

```text
.
│
├── sofa-sample-isle-consumer 
│ 
├── sofa-sample-isle-facade 
│ 
├── sofa-sample-isle-provider 
│ 
└── sofa-sample-isle-bootstrap 
```

各个模块的作用如下：

- sofa-sample-isle-consumer: 演示 XML 方式、Annotation 方式、API 方式引用 JVM 服务；
- sofa-sample-isle-facade: 演示 JVM 服务发布与引用的 API 包；
- sofa-sample-isle-provider: 演示 XML 方式、Annotation 方式、API 方式发布 JVM 服务；
- sofa-sample-isle-bootstrap: 启动包含 SOFABoot 模块的 SOFA Boot 应用。

## 定义服务 API

sofa-sample-isle-facade 模块包含用于演示 JVM 服务发布与引用的 API :

```java
public interface IsleJvmService {
    String message();
}
```

## 发布 JVM 服务

sofa-sample-isle-provider 是一个 SOFABoot 模块，用于演示 XML 方式、Annotation 方式、API 方式发布 JVM 服务。

### 定义 SOFABoot 模块

为 sofa-sample-isle-provider 模块增加 sofa-module.properties 文件，将其定义为 SOFABoot 模块:

```properties
Module-Name=io.monodon.sofastack.sofa-sample-isle-provider
```

### XML 方式发布服务

实现 IsleJvmService 接口:

```java
public class IsleJvmServiceImpl implements IsleJvmService {
    private String message;

    @Override
    public String message() {
        System.out.println(message);
        return message;
    }

    // getters and setters
}
```

增加 META-INF/spring/sofa-sample-isle-provider.xml 文件，将 IsleJvmServiceImpl 发布为 JVM 服务:

```xml
<bean id="isleJvmService" class="io.monodon.sofastack.sample.isle.provider.domain.IsleJvmServiceImpl">
    <property name="message" value="Hello, jvm service xml implementation."/>
</bean>

<sofa:service ref="isleJvmService" interface="io.monodon.sofastack.sample.isle.facade.IsleJvmService">
    <sofa:binding.jvm/>
</sofa:service>
```

### Annotation 方式发布服务

实现 IsleJvmService 接口并增加 @SofaService 注解:

```java
@SofaService(uniqueId = "annotationImpl")
public class IsleJvmServiceAnnotationImpl implements IsleJvmService {
    @Override
    public String message() {
        String message = "Hello, jvm service annotation implementation.";
        System.out.println(message);
        return message;
    }
}
```

为了区分 XML 方式发布的 JVM 服务，注解上需要增加 uniqueId 属性。

将 IsleJvmServiceAnnotationImpl 配置成一个 Spring Bean，保证 @SofaService 注解生效:

```xml
<bean id="sampleJvmServiceAnnotation" class="io.monodon.sofastack.sample.isle.provider.domain.IsleJvmServiceAnnotationImpl"/>
```

### API 方式发布服务

增加 PublishServiceWithClient 类，演示 API 方式发布服务:

```java
public class PublishServiceWithClient implements ClientFactoryAware {
    private ClientFactory clientFactory;

    public void init() {
        ServiceClient serviceClient = clientFactory.getClient(ServiceClient.class);
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setInstance(new IsleJvmServiceImpl(
            "Hello, jvm service service API方式实现."));
        serviceParam.setInterfaceType(IsleService.class);
        serviceParam.setUniqueId("serviceClientImpl");
        serviceClient.service(serviceParam);
    }

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
```

将 PublishServiceWithClient 配置为 Spring Bean，并设置 init-method ，使PublishServiceWithClient 在 Spring 刷新时发布服务:

```xml
<bean id="publishServiceWithClient" class="io.monodon.sofastack.sample.isle.provider.domain.PublishServiceWithClient" init-method="init"/>
```

## 引用 JVM 服务

sofa-sample-isle-consumer 是一个 SOFABoot 模块，用于演示 XML 方式、Annotation 方式、API 方式引用 JVM 服务。

### 定义 SOFABoot 模块

为 sofa-sample-isle-consumer 模块增加 sofa-module.properties 文件，将其定义为 SOFABoot 模块:

```properties
Module-Name=io.monodon.sofastack.sofa-sample-isle-consumer
Require-Module=io.monodon.sofastack.sofa-sample-isle-provider
```

在 sofa-module.properties 文件中需要指定 Require-Module，保证 sofa-sample-isle-provider 模块在 sofa-sample-isle-consumer 模块之前刷新。

### XML 方式引用服务

增加 META-INF/spring/sofa-sample-isle-consumer.xml 文件，引用 sofa-sample-isle-provider 模块发布的服务:

```xml
<sofa:reference id="isleJvmService" interface="io.monodon.sofastack.sample.isle.facade.IsleJvmService">
    <sofa:binding.jvm/>
</sofa:service>
```

### Annotation 方式引用服务

定义 IsleJvmConsumer 类，并在其 isleJvmServiceAnnotationImpl 属性上增加 @SofaReference 注解:

```java
public class IsleJvmConsumer implements ClientFactoryAware {
    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceAnnotation;
}
```

将 IsleJvmConsumer 配置成一个 Spring Bean，保证 @SofaReference 注解生效:

```xml
<bean id="consumer" class="io.monodon.sofastack.sample.isle.consumer.bff.IsleJvmConsumer" init-method="init" />
```

### API 方式引用服务

IsleJvmConsumer 实现 ClientFactoryAware 接口，并在其 init 方法中引用 JVM 服务:

```java
public class IsleJvmConsumer implements ClientFactoryAware {
    private ClientFactory clientFactory;

    public void init() {
        ReferenceClient referenceClient = clientFactory.getClient(ReferenceClient.class);
        ReferenceParam<IsleJvmService> referenceParam = new ReferenceParam<>();
        referenceParam.setInterfaceType(IsleJvmService.class);
        referenceParam.setUniqueId("serviceClientImpl");
        IsleJvmService isJvmServiceClientImpl = referenceClient.reference(referenceParam);
        isJvmServiceClientImpl.message();
    }

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
```

## 启动 SOFABoot 应用

将模块 parent 配置为 SOFABoot:

```xml
<parent>
    <groupId>com.alipay.sofa</groupId>
    <artifactId>sofaboot-dependencies</artifactId>
</parent>
```

为模块增加 isle-sofa-boot-starter 及 sofa-sample-isle-provider 、 sofa-sample-isle-consumer 依赖:

```xml
<dependency>
    <groupId>com.alipay.sofa</groupId>
    <artifactId>isle-sofa-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>io.monodon.sofastack</groupId>
    <artifactId>sofa-sample-isle-provider</artifactId>
</dependency>
<dependency>
    <groupId>io.monodon.sofastack</groupId>
    <artifactId>sofa-sample-isle-consumer</artifactId>
</dependency>
```

为了演示在展示层引用 JVM 服务，我们在演示工程增加了一个 Rest 接口，在 Rest 接口中将引用上文 SOFABoot 模块发布的 JVM 服务。SOFABoot 模块一般用于封装对外发布服务接口的具体实现，属于业务层，Controller 属于展现层内容，我们建议将 Controller 定义放在 Root Application Context 中，然后通过 @SofaReference 引用 SOFABoot 模块发布的服务：

```java
@RestController
public class TestController {
    @SofaReference
    private IsleJvmService isleJvmService;

    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceAnnotationImpl;

    @SofaReference(uniqueId = "serviceClientImpl")
    private IsleJvmService isleJvmServiceClientImpl;

    @RequestMapping("/serviceWithoutUniqueId")
    public String serviceWithoutUniqueId() throws IOException {
        return isleJvmService.message();
    }

    @RequestMapping("/annotationImplService")
    public String annotationImplService() throws IOException {
        return isleJvmServiceAnnotationImpl.message();
    }

    @RequestMapping("/serviceClientImplService")
    public String serviceClientImplService() throws IOException {
        return isleJvmServiceClientImpl.message();
    }
}
```

启动应用，访问[http://localhost:8080/serviceWithoutUniqueId](http://localhost:8080/serviceWithoutUniqueId)、[http://localhost:8080/annotationImplService](http://localhost:8080/annotationImplService)、[http://localhost:8080/serviceClientImplService](http://localhost:8080/serviceClientImplService) 等 URL，可以看到 TestController 成功调用到了 SOFABoot 模块发布的服务。

## 编写测试用例

SOFABoot 模块化测试方法与 Spring Boot 测试方法一致，只需在测试用例上增加 @SpringBootTest 注解及 @RunWith(SpringRunner.class) 注解即可。在测试用例中，还可以使用 @SofaReference 注解，对 SOFABoot 模块发布的服务进行测试：

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class SofaSampleWithIsleTest {
    @SofaReference
    private IsleJvmService isleJvmService;

    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceAnnotationImpl;

    @SofaReference(uniqueId = "serviceClientImpl")
    private IsleJvmService isleJvmServiceClientImpl;

    @Test
    public void test() {
        Assert.assertEquals("Hello, jvm service xml implementation.", isleJvmService.message());
        Assert.assertEquals("Hello, jvm service annotation implementation.",
                isleJvmServiceAnnotationImpl.message());
        Assert.assertEquals("Hello, jvm service service client implementation.",
                isleJvmServiceClientImpl.message());
    }
}
```