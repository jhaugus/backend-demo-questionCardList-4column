package com.lanhuachenyuexi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanhuachenyuexi.model.dto.questionBank.QuestionBankQueryRequest;
import com.lanhuachenyuexi.model.entity.QuestionBank;
import com.lanhuachenyuexi.model.vo.QuestionBankVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 题库服务
 *
 * @author <a href="https://github.com/jhaugus">蓝花晨月夕</a>

 */
public interface QuestionBankService extends IService<QuestionBank> {







    /**
     *
     * 获取查询条件
     *
     * @param questionBankQueryRequest
     * @return
     */
    QueryWrapper<QuestionBank> getQueryWrapper(QuestionBankQueryRequest questionBankQueryRequest);
    

    Page<QuestionBankVO> getQuestionBankVOPage(Page<QuestionBank> questionBankPage, HttpServletRequest request);
}
