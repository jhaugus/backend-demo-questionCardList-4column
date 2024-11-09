package com.lanhuachenyuexi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanhuachenyuexi.common.BaseResponse;
import com.lanhuachenyuexi.common.ErrorCode;
import com.lanhuachenyuexi.common.ResultUtils;
import com.lanhuachenyuexi.exception.ThrowUtils;
import com.lanhuachenyuexi.model.dto.questionBank.QuestionBankQueryRequest;
import com.lanhuachenyuexi.model.entity.QuestionBank;
import com.lanhuachenyuexi.model.vo.QuestionBankVO;
import com.lanhuachenyuexi.service.QuestionBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题库接口
 *
 * @author <a href="https://github.com/jhaugus">蓝花晨月夕</a>

 */
@RestController
@RequestMapping("/questionBank")
@Slf4j
public class QuestionBankController {

    @Resource
    private QuestionBankService questionBankService;


    /**
     * 分页获取题库列表（封装类）
     *
     * @param questionBankQueryRequest
     * @param request
     * @return
     */
    // 前段实际传输 pageSize = 16  sortField = "create_time" sortOrder = "descend"
    // 默认  needQueryQuestionList = false current = 1 pageSize = 10
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionBankVO>> listQuestionBankVOByPage(@RequestBody QuestionBankQueryRequest questionBankQueryRequest,
                                                                       HttpServletRequest request) {
        long current = questionBankQueryRequest.getCurrent();
        long size = questionBankQueryRequest.getPageSize();

        // 限制爬虫
        ThrowUtils.throwIf(size > 200, ErrorCode.PARAMS_ERROR);

        // 查询数据库
        Page<QuestionBank> questionBankPage = questionBankService.page(new Page<>(current, size),
                questionBankService.getQueryWrapper(questionBankQueryRequest));

        // 获取封装类
        return ResultUtils.success(questionBankService.getQuestionBankVOPage(questionBankPage, request));
    }

}
