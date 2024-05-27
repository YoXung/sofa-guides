package io.monodon.sofastack.sample.isle.provider.domain;


import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import lombok.Data;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/28 上午12:32
 */
@Data
public class IsleJvmServiceImpl implements IsleJvmService {
    private String message;


    @Override
    public String message() {
        return "";
    }
}
