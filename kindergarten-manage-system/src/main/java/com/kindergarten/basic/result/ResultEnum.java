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
    SUCCESS_OPTION("200", "操作成功"),

    /**
     * 认证异常
     */
    AUTHENTICATION_ERROR("401", "请登录"),

    /**
     * 授权异常
     */
    AUTHENTIZATION_ERROR("403", "无权限"),

    /**
     * 系统异常，状态码为：500
     * 提示信息为系统异常
     */
    SYSTEM_ERROR("500", "系统异常"),

    /*
     * 此项目的自定义异常，状态码为：500+
     * 状态码和提示信息根据需求扩展
     */

    /**
     * 自定义异常，状态码为：501
     * 验证码错误
     */
    VERIFY_CODE_ERROR("501", "验证码错误"),

    /**
     * 自定义异常，状态码为：502
     * 参数错误
     */
    PARAMETER_ERROR("502", "参数错误"),

    /**
     * 自定义异常，状态码为：503
     * 账号错误
     */
    ACCOUNT_ERROR("503", "账号错误"),

    /**
     * 自定义异常，状态码：504
     * 密码错误
     */
    PASSWORD_ERROR("504", "密码错误"),

    /**
     * 自定义异常，状态码：505
     * 账号已存在
     */
    ACCOUNT_EXIST_ERROR("505", "账号已存在"),

    /**
     * 自定义异常，状态码：508
     * 两次输入密码不一致
     */
    NEW_PASSWORD_CONFIRM_ERROR("508", "两次输入密码不一致"),

    /**
     * 链接异常，状态码为：513
     */
    VERIFY_URL_ERROR("513", "链接已失效，请重新获取链接"),

    /**
     * 禁止对登录中的账号进行操作
     */
    UPDATE_ONESELF_ERROR("509", "禁止对登录中的账号进行操作"),

    /**
     * 账号已注册异常，状态码：516
     */
    EMAIL_EXISTS_ERROR("516", "邮箱已注册"),

    /**
     * 用户未注册异常，状态码：517
     */
    USER_NOT_EXISTS_ERROR("5517", "用户未注册"),

    /**
     * 短信验证码异常，状态码为：527
     */
    PHONE_VERIFY_CODE_ERROR("527", "短信验证码错误"),

    /**
     * 手机已存在异常，状态码：528
     */
    PHONE_EXISTS_ERROR("528", "手机已绑定其它账号"),

    /**
     * 统一社会信用代码已存在，状态码：530
     */
    TYSHXYDM_EXISTS_ERROR("530", "统一社会信用代码已存在"),

    /**
     * 用户名或密码错误，状态码：531
     */
    ACCOUNT_OR_PASSWORD_ERROR("531", "用户名或密码错误"),
    /**
     * 532 验证码已失效
     */
    VERIFY_CODE_IS_INVALID("532", "验证码已失效"),

    /**
     * 533 用户登录已失效，请重新登录！
     */
    ACCOUNT_IS_INVALID("533", "用户登录已失效，请重新登录");

    /**
     * 返回的状态码
     */
    private String code;
    /**
     * 返回的提示信息
     */
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
