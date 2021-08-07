package com.xiaoshen.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.payment.entity
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{
    private Integer status;
    private String msg;
    private T data;

    public CommonResult(Integer status, String msg) {
        this(status, msg, null);
    }
}
