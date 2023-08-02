package com.huike.web.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author itheima
 * @Date 2023-07-11 01:08
 */
@Data
@ApiModel("渠道统计活动统计数据对象")
public class ReportActivityStatisticsData {

    @ApiModelProperty("活动名称")
    private String activity;

    @ApiModelProperty("数量")
    private Integer num;
}
