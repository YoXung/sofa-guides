package io.monodon.sofastack.sample.isle.provider.domain;

import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import com.alipay.sofa.runtime.api.client.ServiceClient;
import com.alipay.sofa.runtime.api.client.param.ServiceParam;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/29 下午9:19
 */
public class PublishServiceWithClient implements ClientFactoryAware {
    private ClientFactory clientFactory;

    public void init() {
        ServiceClient serviceClient = clientFactory.getClient(ServiceClient.class);
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setInstance(new IsleJvmServiceImpl(
                "Hello, jvm service service client implementation."));
        serviceParam.setInterfaceType(IsleJvmService.class);
        serviceParam.setUniqueId("serviceClientImpl");
        serviceClient.service(serviceParam);
    }

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
