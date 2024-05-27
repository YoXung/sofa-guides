package io.monodon.sofastack.sample.isle.consumer.bff;

import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/27 下午11:13
 */
@RestController
public class IsleJvmController implements ClientFactoryAware {
    private ClientFactory clientFactory;

    @Autowired
    private IsleJvmService isleJvmService;

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
