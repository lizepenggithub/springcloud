package com.xiaoshen.springcloud.alibaba.mapper;

import com.xiaoshen.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: xs
 * @Date: 2021/8/4
 * @Description: com.xiaoshen.springcloud.alibaba.mapper
 * @Version: 1.0
 */
@Mapper
public interface OrderMapper {

    public int createOrder(Order order);

    public int updateOrder(@Param("id") Long id);
}
