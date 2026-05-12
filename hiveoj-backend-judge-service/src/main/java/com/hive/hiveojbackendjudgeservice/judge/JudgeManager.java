package com.hive.hiveojbackendjudgeservice.judge;


import com.hive.hiveojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.hive.hiveojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.hive.hiveojbackendjudgeservice.judge.strategy.JudgeContext;
import com.hive.hiveojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.hive.hiveojbackendmodel.codesandbox.JudgeInfo;
import com.hive.hiveojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理 简化调用
 */
@Service
public class JudgeManager {

    /**
     * 判题
     *
     * @param judgeContext@return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (language.equals("java")) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
