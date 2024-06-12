package io.monodon.sofastack.sample.isle.bootstrap;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/3 下午5:26
 */
@SpringBootTest
@DisplayName("sofa-sample-isle-bootstrap junit5测试")
public class SofaSampleWithIsleTest {

    @SofaReference
    private IsleJvmService isleJvmService;

    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceAnnotationImpl;

    @SofaReference(uniqueId = "serviceClientImpl")
    private IsleJvmService isleJvmServiceClientImpl;

    @Test
    public void test() {
        assertEquals("Hello, jvm service xml implementation.", isleJvmService.message());
        assertEquals("Hello, jvm service annotation implementation.",
                isleJvmServiceAnnotationImpl.message());
        assertEquals("Hello, jvm service service client implementation.", isleJvmServiceClientImpl.message());

    }
}
