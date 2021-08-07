package com.xiaoshen.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Auther: xs
 * @Date: 2021/8/4
 * @Description: com.xiaoshen.springcloud.alibaba.domain
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
