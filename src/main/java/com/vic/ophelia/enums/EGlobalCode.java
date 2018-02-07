package com.vic.ophelia.enums;

import lombok.Getter;

/**
 * @author vicdor
 * @create 2018-02-07 16:35
 */
@Getter
public enum EGlobalCode {
    GLOBAL_LITTLE_TIP(2333, "小朋友，你还太小哦");
    private Integer code;
    private String msg;

    EGlobalCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
