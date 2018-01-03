package com.yep.churchile.utils;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

    /**
     * serialVersionUID:TODO 请描述这个变量的含义。
     */
    public final static ErrorMsg SUCCESS = new ErrorMsg("success", "操作成功");
    public final static ErrorMsg EXCEPTION = new ErrorMsg("exception", "系统忙，请稍后重试");
    public final static ErrorMsg REQUEST_FAILED = new ErrorMsg("request.failed", "网络请求异常");
    public final static ErrorMsg ERROR_NO_DATA = new ErrorMsg("error.no.data", "无数据");
    public final static ErrorMsg ERROR_PARA_IS_NULL = new ErrorMsg("error.para.is.null", "请求参数PARA_NAME未设定");
    private static final long serialVersionUID = -532855965191069096L;
    private ErrorMsg errorMsg;
    private T data;
    private Integer time;

    public static <T> ResultData<T> ok(T data) {
        ResultData<T> result = new ResultData<T>();
        result.setErrorMsg(SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ResultData<T> error(ErrorMsg error) {
        ResultData<T> result = new ResultData<T>();
        result.setErrorMsg(error);
        return result;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorMsg getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(ErrorMsg errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccessful() {
        return SUCCESS.getCode().equals(this.errorMsg.getCode());
    }

    public boolean errorFor(ErrorMsg errMsg) {
        return this.errorMsg.getCode().equalsIgnoreCase(errMsg.getCode());
    }

    public static class ErrorMsg implements Serializable {
        private static final long serialVersionUID = -8899306544168830547L;
        private String code;
        private String message;

        public ErrorMsg(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public ErrorMsg setParam(String key, String value) {
            ErrorMsg copy = new ErrorMsg(this.code, this.message.replace(key, value));
            return copy;
        }

        public ErrorMsg withParam(String value) {
            return setParam("PARA_NAME", value);
        }

        @Override
        public String toString() {
            return "[code=" + code + ", message=" + message + "]";
        }
    }

    @Override
    public String toString() {
        return "[errorMsg=" + errorMsg + ", data=" + data + "]";
    }
}
