package com.kindergarten.exception;

import com.kindergarten.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author lxcecho 909231497@qq.com
 * @since 22:50 05-12-2022
 */
@ControllerAdvice
@Slf4j
public class KindergartenControllerAdvice {

    /**
     * 捕捉自定义异常类 CustomException.class
     */
    @ResponseBody
    @ExceptionHandler(value = KindergartenException.class)
    public ResultVO tcErrorHandler(KindergartenException ex) {

        log.error(ex.getMsg());

        return ResultVO.error(ex.getCode(), ex.getMsg());

    }

    /**
     * 捕捉全局异常 Exception.class
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO errorHandler(Exception ex) {

        log.error(ex.getMessage());

        return ResultVO.error("-1", ex.getMessage());

    }

}