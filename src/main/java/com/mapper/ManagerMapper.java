package com.mapper;

import com.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: EvenHuang
 * @Date: 2019/6/19 15:50
 */
@Mapper
public interface ManagerMapper {
    @Select(" select * from manager where account=#{account}")
    Manager getManager(String account);
}
