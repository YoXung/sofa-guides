package io.monodon.sofastack.sample.ddd.adapter.assembler;

import java.util.function.Function;

/**
 * @author yaoxiang
 * @description 任务DTO组装器
 * @date 2024/8/20 21:02
 */
public class TaskDTOAssembler {
    public static EndorsementTaskModifyCmd toEndorsementTaskModifyCmd(ModifyTaskVO modifyTaskModifyVO) {
        Function<ModifyTaskVO, EndorsementTaskModifyCmd> modifyTaskVOtoEndorsementTaskModifyCmd = (endorsementTaskModifyCmd) -> {
            return new EndorsementTaskModifyCmd();
        };
        return modifyTaskVOtoEndorsementTaskModifyCmd.apply(modifyTaskModifyVO);
    }
}
