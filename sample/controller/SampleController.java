package com.dalbit.sample.controller;

import com.dalbit.common.code.Status;
import com.dalbit.common.vo.JsonOutputVo;
import com.dalbit.sample.service.sampleService;
import com.dalbit.sample.vo.procedure.*;
import com.dalbit.sample.vo.request.*;
import com.dalbit.exception.GlobalException;
import com.dalbit.util.DalbitUtil;
import com.dalbit.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/sample")
@Scope("prototype")
public class SampleController {
    @Autowired
    GsonUtil gsonUtil;
    @Autowired
    SampleService sampleService;


    /**
     * 리스트
     */
    @GetMapping("/list")
    public String getList(@Valid SampleListVo sampleListVo, BindingResult bindingResult, HttpServletRequest request) throws GlobalException {
        DalbitUtil.throwValidaionException(bindingResult, Thread.currentThread().getStackTrace()[1].getMethodName());
        P_SampleListVo apiData = new P_SampleListVo(sampleListVo, request);
        String result = sampleService.callList(apiData);
        return result;
    }
}
