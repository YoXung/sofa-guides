### Annotation 方式发布

> 警告 
> 如果一个服务已经被加上了 @SofaService 的注解，它就不能再用 XML 的方式去发布服务了，选择一种方式发布服务，而不是两种混用。

除了通过 XML 方式发布 JVM 服务和引用之外，SOFABoot 还提供了 Annotation 的方式来发布和引用 JVM 服务。通过 Annotation 方式发布 JVM 服务，只需要在实现类上加一个 @SofaService 注解即可，如下：
```java
@SofaService
public class SampleImpl implements SampleInterface {
public void test() {

    }
}
```

> 提示
> @SofaService 的作用是将一个 Bean 发布成一个 JVM 服务，这意味着虽然你可以不用再写 <sofa:service/> 的配置，但是还是需要事先将 @SofaService 所注解的类配置成一个 Spring Bean。

在使用 XML 配置 <sofa:service/> 的时候，我们配置了一个 interface 属性，但是在使用 @SofaService 注解的时候，却没有看到有配置服务接口的地方。这是因为当被 @SofaService 注解的类只有一个接口的时候，框架会直接采用这个接口作为服务的接口。当被 @SofaService 注解的类实现了多个接口时，可以设置 @SofaService 的 interfaceType 字段来指定服务接口，比如下面这样：
```java
@SofaService(interfaceType=SampleInterface.class)
public class SampleImpl implements SampleInterface, Serializable {
public void test() {

    }
}
```
和 @SofaService 对应，Sofa 提供了 @SofaReference 来引用一个 JVM 服务。假设我们需要在一个 Spring Bean 中使用 SampleJvmService 这个 JVM 服务，那么只需要在字段上加上一个 @SofaReference 的注解即可：
```java
public class SampleServiceRef {
@SofaReference
private SampleService sampleService;
}
```
和 @SofaService 类似，我们也没有在 @SofaReference 上指定服务接口，这是因为 @SofaReference 在不指定服务接口的时候，会采用被注解字段的类型作为服务接口，你也可以通过设定 @SofaReference 的 interfaceType 属性来指定：
```java
public class SampleServiceRef {
@SofaReference(interfaceType=SampleService.class)
private SampleService sampleService;
}
```
使用 @SofaService 注解发布服务时，需要在实现类上打上 @SofaService 注解；在 Spring Boot 使用 Bean Method 创建 Bean 时，会导致 @Bean 和 @SofaService 分散在两处，而且无法对同一个实现类使用不同的 unique id。因此自 SOFABoot v2.6.0 及 v3.1.0 版本起，支持 @SofaService 作用在 Bean Method 之上，例如：
```java
@Configuration
public class SampleSofaServiceConfiguration {
@Bean("sampleSofaService")
@SofaService(uniqueId = "service1")
SampleService service() {
return new SampleServiceImpl("");
    }
}
```
同样为了方便在 Spring Boot Bean Method 使用注解 @SofaReference 引用服务，自 SOFABoot v2.6.0 及 v3.1.0 版本起，支持在 Bean Method 参数上使用 @SofaReference 注解引用 JVM 服务，例如：
```java
@Configuration
public class MultiSofaReferenceConfiguration {
@Bean("sampleReference")
TestService service(@Value("$spring.application.name") String appName,
@SofaReference(uniqueId = "service") SampleService service) {
return new TestService(service);
    }
}
```