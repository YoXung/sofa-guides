package io.monodon.sofastack.sample.rpc.client;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.monodon.sofastack.sample.rpc.client.ui.TestVO;
import io.monodon.sofastack.sample.rpc.facade.AnnotationService;
import io.monodon.sofastack.sample.rpc.facade.InvokeService;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoxiang
 * @description 泛化调用方
 * @date 2024/6/27 下午8:44
 */
@RestController
@RequestMapping("/rpc")
public class InvokeClient {
    @SofaReference(interfaceType = InvokeService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private AnnotationService annotationService;
    @GetMapping("/incvoke/{str}")
    public String sayClienInvoke(@PathVariable("str") String str) {
        return "";
    }

    @PostMapping("/incvokes")
    public String testInvoke(@RequestBody TestVO testVO) {
        return "";
    }
}
