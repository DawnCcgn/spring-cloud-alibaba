package com.hpw.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gn
 * @date 2021/6/22 18:08
 */
@NoArgsConstructor
@Data
public class CommonResult <T> {

    private Integer code;
    private String msg;
    private  T data;

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
