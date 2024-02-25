package com.example.check;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2023/11/12 11:35
 * 4
 */
public enum CheckPatternEnum {
    NUM_01("，只支持纯数字类型！", "[0-9]+"),
    NUM_02("，只支持整数，浮点数或负数！", "-?\\d+(\\.\\d+)?"),
    NUM_ENG("，只支持数字,英文类型！", "^[A-Za-z0-9]+$"),
    CHN_ENG_NUM("，只支持中英文,数字类型！", "^[\u4E00-\u9FA5A-Za-z0-9]+$"),
    ID_CARD("，应为身份证号码类型！", "d{15}|d{18}"),
    EMAIL("，应为邮箱类型！", "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"),
    PHONE("，应为手机号类型！", "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");

    private String pattern;
    private String errorInfo;

    CheckPatternEnum(String errorInfo, String pattern) {
        this.pattern = pattern;
        this.errorInfo = errorInfo;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
