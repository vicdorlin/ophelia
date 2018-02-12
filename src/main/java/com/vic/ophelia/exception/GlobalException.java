package com.vic.ophelia.exception;

import com.vic.ophelia.enums.EGlobalCode;
import lombok.Getter;
import lombok.Setter;

/**
 * spring框架只会对RuntimeException进行事务回滚
 *
 * @author vicdor
 * @create 2018-02-07 16:15
 */
@Getter
@Setter
public class GlobalException extends RuntimeException {
    private Integer code;

    public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GlobalException(EGlobalCode globalCode) {
        this(globalCode.getCode(), globalCode.getMsg());
    }

    public GlobalException(String message) {
        super(message);
        this.code = -1991;
    }
}
