package com.kindergarten.basic.exception;

import com.kindergarten.basic.result.ResultEnum;
import com.kindergarten.basic.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
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
    public ResultVO<String> tcErrorHandler(KindergartenException ex) {

        log.error(ex.getMsg(), ex);

        return ResultVO.error(ex.getCode(), ex.getMsg());

    }

    /**
     * 捕捉全局异常 Exception.class
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO<String> errorHandler(Exception ex) {

        log.error(ex.getMessage(), ex);

        return ResultVO.error(ResultEnum.SYSTEM_ERROR.getCode(), ex.getMessage());

    }

}
