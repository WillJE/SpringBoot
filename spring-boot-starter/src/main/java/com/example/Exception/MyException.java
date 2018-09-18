package com.example.Exception;

import com.example.Emuns.ResultEmun;

public class MyException extends Exception {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MyException(ResultEmun resultEmun) {
        super(resultEmun.getMessage());
        this.code = resultEmun.getCode();
    }
}
