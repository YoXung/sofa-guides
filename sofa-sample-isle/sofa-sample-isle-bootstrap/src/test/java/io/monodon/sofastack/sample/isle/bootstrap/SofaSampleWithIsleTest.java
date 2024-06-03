package io.monodon.sofastack.sample.isle.bootstrap;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/3 下午5:26
 */
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
