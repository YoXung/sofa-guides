package io.monodon.sofastack.sample.isle.consumer.bff;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.aware.ClientFactoryAware;
import com.alipay.sofa.runtime.api.client.ClientFactory;
import com.alipay.sofa.runtime.api.client.ReferenceClient;
import com.alipay.sofa.runtime.api.client.param.ReferenceParam;
import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/27 下午11:13
 */
public class IsleJvmCosumer implements ClientFactoryAware {
    private ClientFactory clientFactory;

    @Autowired
    private IsleJvmService isleJvmService;

    @SofaReference(uniqueId = "annotationImpl")
    private IsleJvmService isleJvmServiceByFieldAnnotation;
    public void init() {
        isleJvmService.message();
        isleJvmServiceByFieldAnnotation.message();

        ReferenceClient referenceClient = clientFactory.getClient(ReferenceClient.class);
        ReferenceParam<IsleJvmService> referenceParam = new ReferenceParam<IsleJvmService>();
        referenceParam.setInterfaceType(IsleJvmService.class);
        referenceParam.setUniqueId("serviceClientImpl");
        IsleJvmService isleJvmServiceClientImpl = referenceClient.reference(referenceParam);
        isleJvmServiceClientImpl.message();
    }


    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
