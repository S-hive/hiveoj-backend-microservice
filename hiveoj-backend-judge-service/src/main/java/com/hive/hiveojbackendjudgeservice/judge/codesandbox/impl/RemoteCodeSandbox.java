package com.hive.hiveojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hive.hivebackendcommon.common.ErrorCode;
import com.hive.hivebackendcommon.exception.BusinessException;
import com.hive.hiveojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.hive.hiveojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.hive.hiveojbackendmodel.codesandbox.ExecuteCodeResponse;

/**
 * 远程代码沙箱 (调用接口)
 */
public class RemoteCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://192.168.197.130:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,
                    "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);

    }
}
