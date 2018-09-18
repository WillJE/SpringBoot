package com.example.Emuns;

public enum  ResultEmun {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    FALI(0,"失败"),
    ;

    private Integer code;

    private String message;

    ResultEmun(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
