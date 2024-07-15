package io.monodon.sofastack.sample.rpc.server;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.monodon.sofastack.sample.rpc.facade.AnnotationService;
import io.monodon.sofastack.sample.rpc.facade.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/27 下午5:46
 */
@Service
@SofaService(interfaceType = DubboService.class, bindings = { @SofaServiceBinding(bindingType = "dubbo") }, uniqueId = "dubboDemo")
public class DubboServiceImpl implements DubboService {
    @Override
    public String sayDubbo(String str) {
        return String.format("sofarpc dubbo协议实现，参数为：%s", str);
    }
}
