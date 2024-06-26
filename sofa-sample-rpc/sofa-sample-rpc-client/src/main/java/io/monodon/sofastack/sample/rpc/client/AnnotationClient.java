package io.monodon.sofastack.sample.rpc.client;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.monodon.sofastack.sample.rpc.facade.AnnotationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoxiang
 * @description 注解方式rpc
 * @date 2024/6/26 上午11:12
 */
@RestController
@RequestMapping("/rpc")
public class AnnotationClient {
    @SofaReference(interfaceType = AnnotationService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private AnnotationService annotationService;
    @GetMapping("/annotation/{str}")
    public String sayClientAnnotation(@PathVariable("str") String str) {
        return annotationService.sayAnnotation(str);
    }
}
