package io.monodon.sofastack.sample.rpc.server;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.monodon.sofastack.sample.rpc.facade.AnnotationService;
import org.springframework.stereotype.Service;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/26 上午11:16
 */
@Service
@SofaService(interfaceType = AnnotationService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public String sayAnnotation(String str) {
        return String.format("sofarpc 注解方式实现，参数为：%s", str);
    }
}
