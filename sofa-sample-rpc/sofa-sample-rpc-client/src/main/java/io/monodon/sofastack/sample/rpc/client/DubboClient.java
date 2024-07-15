package io.monodon.sofastack.sample.rpc.client;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.monodon.sofastack.sample.rpc.facade.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoxiang
 * @description dubbo协议目前只支持zookeeper作为注册中心
 * @date 2024/6/27 下午5:50
 */
@RestController
@RequestMapping("/rpc")
public class DubboClient {
    @SofaReference(interfaceType = DubboService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "dubbo"), uniqueId = "dubboDemo")
    private DubboService dubboService;
    @GetMapping("/dubbo/{str}")
    public String sayClientDubbo(@PathVariable("str") String str) {
        return dubboService.sayDubbo(str);
    }
}
