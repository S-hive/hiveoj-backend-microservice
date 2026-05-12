package com.hive.hiveojbackendjudgeservice.judge;


import com.hive.hiveojbackendmodel.model.entity.QuestionSubmit;

/**
 * 判题服务
 */
public interface JudgeService {

    /**
     * 判题
     *
     * @param questionSubmit
     * @return
     */
    QuestionSubmit doJudge(long questionSubmit);
}
