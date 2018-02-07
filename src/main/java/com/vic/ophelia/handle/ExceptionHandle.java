package com.vic.ophelia.handle;

import com.vic.ophelia.domain.ResultVo;
import com.vic.ophelia.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vicdor
 * @create 2018-02-07 15:43
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    public ResultVo handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return ResultVo.fail(exception.getCode(), exception.getMessage());
        }
        log.error("【系统异常】{}", e.toString());
        return ResultVo.fail();
    }
}
