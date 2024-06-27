package io.monodon.sofastack.sample.rpc.server;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import io.monodon.sofastack.sample.rpc.facade.RestService;
import org.springframework.stereotype.Service;

/**
 * @author yaoxiang
 * @description
 * @date 2024/6/27 下午6:12
 */
@Service
@SofaService(interfaceType = RestService.class, bindings = { @SofaServiceBinding(bindingType = "rest") })
public class RestServiceImpl implements RestService {
    @Override
    public String sayRest(String str) {
        return String.format("sofarpc rest协议实现，参数为：%s", str);
    }
}
