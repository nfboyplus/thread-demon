package com.utils;

import lombok.Getter;

/**
 * 信息提示集合，错误码为5位，前两位代表所属模块，每个模块预留1000个错误码
 * @date 2019年3月7日 下午8:06:11
 * @version v1.0
 */
@Getter
public enum ResultCode {

    /* 系统信息，以00开头 */
    SYS_OK("00000", "操作成功"),
    ADD_SUCCESS("00000", "新建成功"),
    EDIT_SUCCESS("00000", "更新成功"),
    DELETE_SUCCESS("00000", "删除成功"),
    SYS_INVALID_LOGIN("00001", "登录已失效，请重新登录"),
    SYS_ACCOUNT_ERROR("00002", "账号/密码错误"),
    ENUM_UNDEFINED("00003", "未知枚举"),
    SYS_SERVICE_ERROR("00004", "服务器忙，请稍后"),
    SYS_INVAILD_PARAMETER("00005", "参数类型不匹配，请确认参数传值对应的类型是否正确"),
    SYS_MISS_PARAMETER("00006", "缺少必要的参数，请检查提交的参数和路径参数"),
    CALL_REMOTE_SERVICE_EXCEPTION("00007", "调用远程服务异常"),
    NOT_AUTH("00008", "暂无权限！"),
    RECORD_CURRENT_NOTEXIST("00009", "暂无权限！"),

    /**
     * 自定义错误提示
     */
    DEFINED_ERROR("99999", "#");

    String code;
    String message;

    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }

}
