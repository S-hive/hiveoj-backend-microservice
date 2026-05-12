package com.hive.hiveojbackendjudgeservice.judge.strategy;


import com.hive.hiveojbackendmodel.codesandbox.JudgeInfo;

public interface JudgeStrategy {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
