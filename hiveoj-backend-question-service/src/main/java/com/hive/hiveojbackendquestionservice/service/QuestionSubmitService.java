package com.hive.hiveojbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hive.hiveojbackendmodel.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.hive.hiveojbackendmodel.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.hive.hiveojbackendmodel.model.entity.QuestionSubmit;
import com.hive.hiveojbackendmodel.model.entity.User;
import com.hive.hiveojbackendmodel.model.vo.QuestionSubmitVO;

/**
 * @author Liyal
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2026-05-04 21:40:44
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
