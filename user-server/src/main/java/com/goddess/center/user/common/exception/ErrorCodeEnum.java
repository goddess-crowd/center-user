package com.goddess.center.user.common.exception;

/**
 * 错误码
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午4:34
 * @Copyright © 女神帮
 */
public enum ErrorCodeEnum {

    /**
     * 参数错误
     */
    PARAM_ILLEGAL("参数错误", "001", ErrorType.SYS),

    ;

    private String errorMsg;
    private String errorCode;
    private ErrorType errorType;

    ErrorCodeEnum(String errorMsg, String errorCode, ErrorType errorType) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.errorType = errorType;
    }
    ErrorCodeEnum(String errorMsg, String errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.errorType =  ErrorType.BIZ;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public enum ErrorType {
        //业务异常
        BIZ("biz"),
        //系统异常
        SYS("sys");

        ErrorType(String code) {
            this.code = code;
        }

        String code;

        public String getCode() {
            return code;
        }
    }

}
