package com.exception;

import com.utils.ResultCode;

/**
 * 自定义公用接口异常类
 *
 * @version 1.0.0
 */
public class SystemServiceException extends RuntimeException {


    private static final long serialVersionUID = -396449728694696120L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SystemServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public SystemServiceException(ResultCode code) {
        super(code.getMessage());
        this.code = code.getCode();
        this.msg = code.getMessage();
    }

    public SystemServiceException(ResultCode code, String... arg) {
        super(replaceMessage(code.getMessage(), arg));
        this.code = code.getCode();
        this.msg = replaceMessage(code.getMessage(), arg);
    }

    private static String replaceMessage(String message, String... arg) {
        for (String replaceStr : arg) {
            message = message.replaceFirst("#", replaceStr);
        }
        return message;
    }
}
