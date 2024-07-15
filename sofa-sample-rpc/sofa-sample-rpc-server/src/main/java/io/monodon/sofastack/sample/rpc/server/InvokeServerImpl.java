package io.monodon.sofastack.sample.rpc.server;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.monodon.sofastack.sample.rpc.facade.AnnotationService;
import io.monodon.sofastack.sample.rpc.facade.InvokeService;
import org.springframework.stereotype.Service;

/**
 * @author yaoxiang
 * @description 泛化服务提供方
 * @date 2024/6/27 下午8:46
 */
@Service
@SofaService(interfaceType = InvokeService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class InvokeServerImpl implements InvokeService {
    @Override
    public String sayInvoke(String str) {
        return "";
    }
}
