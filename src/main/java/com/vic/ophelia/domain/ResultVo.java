package com.vic.ophelia.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author vicdor
 * @create 2018-02-07 15:04
 */
@Getter
@Setter
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;

    private ResultVo() {
        code = 100;
    }

    private ResultVo(T t) {
        this();
        this.data = t;
    }

    private ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultVo ok() {
        return new ResultVo();
    }

    public static ResultVo ok(Object data) {
        return new ResultVo(data);
    }

    public static ResultVo fail(Integer code, String msg) {
        return new ResultVo(code, msg);
    }

    public static ResultVo fail(String msg) {
        return fail(-1000, msg);
    }

    public static ResultVo fail() {
        return fail(-2000, "未知错误");
    }
}
