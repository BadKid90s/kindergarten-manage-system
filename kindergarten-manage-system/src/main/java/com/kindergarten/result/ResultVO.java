package com.kindergarten.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lxcecho 909231497@qq.com
 * @since 22:41 05-12-2022
 */
@Setter
@Getter
public class ResultVO<T> {

    /**
     * 返回结果
     */
    private T data;

    /**
     * 返回的状态码
     */
    private String code;

    /**
     * 返回的提示信息
     */
    private String msg;


    /**
     * 成功，但不返回 data
     *
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> success() {
        ResultVO<T> result = new ResultVO<>();
        result.setCode(ResultEnum.SUCCESS_OPTION.getCode());
        result.setMsg(ResultEnum.SUCCESS_OPTION.getMsg());
        return result;
    }

    /**
     * 成功，返回 data
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> result = success();
        result.setData(object);
        return result;
    }

    /**
     * 失败，返回状态码和状态信息
     *
     * @param resultEnum
     * @return
     */
    public static ResultVO<ResultEnum> error(ResultEnum resultEnum) {
        ResultVO<ResultEnum> result = new ResultVO<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    /**
     * 失败，返回状态码和状态信息<br>
     * 用于全局异常处理类GbaControllerAdvice
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> error(String code, String msg) {
        ResultVO<T> result = new ResultVO<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
