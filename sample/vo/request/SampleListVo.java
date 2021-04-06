package com.dalbit.sample.vo.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SampleListVo {
    private Integer page;
    private Integer records;
}
