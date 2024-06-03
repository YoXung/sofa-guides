package io.monodon.sofastack.sample.isle.provider.domain;


import io.monodon.sofastack.sample.isle.facade.IsleJvmService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yaoxiang
 * @description
 * @date 2024/5/28 上午12:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IsleJvmServiceImpl implements IsleJvmService {
    private String message;

    @Override
    public String message() {
        return message;
    }
}
