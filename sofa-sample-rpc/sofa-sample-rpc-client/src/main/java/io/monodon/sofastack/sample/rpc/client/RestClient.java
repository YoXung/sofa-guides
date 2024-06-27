package io.monodon.sofastack.sample.rpc.client;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import io.monodon.sofastack.sample.rpc.facade.RestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoxiang
 * @description REST协议
 * @date 2024/6/27 下午5:56
 */
@RestController
@RequestMapping("/rpc")
public class RestClient {
    @SofaReference(interfaceType = RestService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "rest"))
    private RestService restService;
    @GetMapping("/rest/{str}")
    public String sayClientRest(@PathVariable("str") String str) {
        return restService.sayRest(str);
    }
}
