package com.hive.hiveojbackendjudgeservice.judge.codesandbox;


import com.hive.hiveojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.hive.hiveojbackendmodel.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
