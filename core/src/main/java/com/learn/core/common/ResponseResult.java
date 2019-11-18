package com.learn.core.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 响应结果
 */
@Data
@ApiModel(value="ResponseDomain对象", description="响应结果")
public class ResponseResult {

    private ResponseResult() {
        this.status = 200;
        this.success = false;
        this.data = "";
        this.message = "";
        this.detailMessage = "";
    }

    /**
     * 响应码
     */
    @ApiModelProperty(name = "status", value = "响应码")
    private int status;
    /**
     * 是否执行成功
     */
    @ApiModelProperty(name = "success", value = "是否执行成功")
    private boolean success;
    /**
     * 返回的数据
     */
    @ApiModelProperty(name = "data", value = "返回的数据")
    private Object data;
    /**
     * 导致错误的描述
     */
    @ApiModelProperty(name = "message", value = "导致错误的描述")
    private String message;
    /**
     * 导致错误的详细描述
     */
    @ApiModelProperty(name = "detailMessage", value = "导致错误的详细描述")
    private String detailMessage;
    /**
     * 重定向地址
     */
    @ApiModelProperty(name = "redirect_url", value = "重定向地址")
    private String redirectUrl;

    /**
     * Description: 操作失败
     * @return
     */
    public static ResponseResult fail() {
        return fail(null);
    }

    /**
     * Description: 操作失败
     * @return
     */
    public static ResponseResult fail(String msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(500);
        responseResult.setSuccess(false);
        responseResult.setMessage(msg);
        return responseResult;
    }

    /**
     * Description: 成功
     * @return
     */
    public static ResponseResult success() {
        return success(null);
    }

    /**
     * Description: 成功
     * @return
     */
    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setData(data);
        return responseResult;
    }

}