package io.monodon.sofastack.sample.isle.provider.domain;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/29 下午9:17
 */
@SofaService(uniqueId = "annotationImpl")
public class IsleJvmServiceAnnotationImpl implements IsleJvmService {
    @Override
    public String message() {
        String message = "Hello, jvm service 注解方式实现.";
        System.out.println(message);
        return message;
    }
}
