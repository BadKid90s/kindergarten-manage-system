package com.kindergarten.exception;

import com.kindergarten.result.ResultEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常类
 *
 * @author lxcecho 909231497@qq.com
 * @since 22:50 05-12-2022
 */
@Getter
@Setter
@Slf4j
public class KindergartenException extends RuntimeException {

    /**
     * 异常状态码
     */
    private final String code;

    /**
     * 异常信息
     */
    private final String msg;

    public KindergartenException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public KindergartenException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
