package com.kindergarten.basic.result;

/**
 * 返回结果的状态码及提示信息
 *
 * @author lxcecho 909231497@qq.com
 * @since 22:41 05-12-2022
 */
public enum ResultEnum {

    /**
     * 操作成功，状态码为：200
     * 提示信息为操作成功
     */
    SUCCESS_OPTION(200, "操作成功"),

    /**
     * 系统异常，状态码为：500
     * 提示信息为系统异常
     */
    SYSTEM_ERROR(500, "系统异常");


    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的提示信息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
