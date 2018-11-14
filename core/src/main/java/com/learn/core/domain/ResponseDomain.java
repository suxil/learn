package com.learn.core.domain;

import org.springframework.data.domain.Page;

/**
 * 响应结果
 */
public class ResponseDomain {

    public ResponseDomain() {
        this.success = false;
        this.data = "";
        this.message = "";
        this.detailMessage = "";
    }

    private boolean success; // 是否成功执行的标志 ： true->成功 , false->失败
    private Object data; // 返回的数据串
    private String message; // 导致错误的描述
    private String detailMessage; // 导致错误的详细描述
    private String redirectUrl; // 重定向地址

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Description:
     * <br/>错误的详细信息
     *
     * @return
     */
    public String getDetailMessage() {
        return detailMessage;
    }

    /**
     * Description:
     * <br/>错误的详细信息
     *
     * @param detailMessage
     */
    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * Description: 操作失败
     * @return
     */
    public static ResponseDomain fail() {
        return fail(null);
    }

    /**
     * Description: 操作失败
     * @return
     */
    public static ResponseDomain fail(String msg) {
        ResponseDomain responseDomain = new ResponseDomain();
        responseDomain.setSuccess(false);
        responseDomain.setMessage(msg);
        return responseDomain;
    }

    /**
     * Description: 成功
     * @return
     */
    public static ResponseDomain success() {
        return success(null);
    }

    /**
     * Description: 成功
     * @return
     */
    public static ResponseDomain success(Object data) {
        ResponseDomain responseDomain = new ResponseDomain();
        responseDomain.setSuccess(true);
        responseDomain.setData(data);
        return responseDomain;
    }

    /**
     * 控制器返回模板
     * @param action
     * @return
     */
    public static ResponseDomain executor(ResponseCallback action) {
        if (action != null) {
            Object data = action.doCallback();
            if (data != null) {
                if (data instanceof Page) {
                    return success(PageDomain.initPage((Page<Object>) data));
                }
                return success(data);
            }
        }
        return fail("操作异常");
    }

}
