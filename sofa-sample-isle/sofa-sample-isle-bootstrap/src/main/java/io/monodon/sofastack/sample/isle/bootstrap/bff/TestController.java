package io.monodon.sofastack.sample.isle.bootstrap.bff;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/17 下午8:52
 */
@RestController
public class TestController {
    @SofaReference
    private IsleJvmService isleJvmService;

    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceAnnotation;

    @SofaReference(uniqueId = "serviceClientImpl")
    private IsleJvmService isleJvmServiceClient;

    @RequestMapping("/serviceWithoutUniqueId")
    public String serviceWithoutUniqueId() throws IOException {
        return isleJvmService.message();
    }

    @RequestMapping("/annotationImplService")
    public String annotationImplService() throws IOException {
        return isleJvmServiceAnnotation.message();
    }

    @RequestMapping("/serviceClientImplService")
    public String serviceClientImplService() throws IOException {
        return isleJvmServiceClient.message();
    }
}
