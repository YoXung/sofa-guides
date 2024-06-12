package io.monodon.sofastack.sample.isle.bootstrap.bff;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/serviceWithoutUniqueId")
    public String serviceWithoutUniqueId() throws IOException {
        return isleJvmService.message();
    }

    @GetMapping("/annotationImplService")
    public String annotationImplService() throws IOException {
        return isleJvmServiceAnnotation.message();
    }

    @GetMapping("/serviceClientImplService")
    public String serviceClientImplService() throws IOException {
        return isleJvmServiceClient.message();
    }
}
