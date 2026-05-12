package com.hive.hiveojbackendjudgeservice.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.hive.hiveojbackendmodel.codesandbox.JudgeInfo;
import com.hive.hiveojbackendmodel.model.dto.question.JudgeCase;
import com.hive.hiveojbackendmodel.model.dto.question.JudgeConfig;
import com.hive.hiveojbackendmodel.model.entity.Question;
import com.hive.hiveojbackendmodel.model.enums.JudgeInfoMessageEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * java程序判题策略
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy {
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<String> inputList = Optional.ofNullable(judgeContext.getInputList())
                .orElseGet(ArrayList::new);
        List<String> outputList = Optional.ofNullable(judgeContext.getOutputList())
                .orElseGet(ArrayList::new);
        Question question = judgeContext.getQuestion();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        long memory = Optional.ofNullable(judgeInfo)
                .map(JudgeInfo::getMemory)
                .orElse(0L);
        long time = Optional.ofNullable(judgeInfo)
                .map(JudgeInfo::getTime)
                .orElse(0L);

        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);

        if (outputList.size() != inputList.size() || inputList.isEmpty()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        for (int i = 0; i < outputList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if (!judgeCase.getOutput().equals(outputList.get(i))) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }

        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        Long needTimeLimit = judgeConfig.getTimeLimit();
        if (memory > needMemoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        // 特殊策略: java程序需要额外执行10s
        long JAVA_PROGRAM_TIME_COST = 10000L;
        if (time - JAVA_PROGRAM_TIME_COST > needTimeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;
    }
}
