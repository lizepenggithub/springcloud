package com.xiaoshen.springcloud.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Auther: xs
 * @Date: 2021/8/4
 * @Description: com.xiaoshen.springcloud.alibaba.mapper
 * @Version: 1.0
 */
@Mapper
public interface AccountMapper {

    //扣减库存信息
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
