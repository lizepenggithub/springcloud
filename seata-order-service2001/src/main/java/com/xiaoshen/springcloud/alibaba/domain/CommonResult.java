package com.xiaoshen.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: xs
 * @Date: 2021/8/4
 * @Description: com.xiaoshen.springcloud.alibaba.domain
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
