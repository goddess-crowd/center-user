package com.goddess.center.user.exception;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/19 上午11:11
 * @Copyright © 女神帮
 */
public enum EnumException {
    EXCEPTION_1000("1000","参数错误"),
    ;

    private String msg;

    private String code;

    EnumException(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
