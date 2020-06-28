package com.jwt.mapper;

import com.jwt.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    @Select("select * from user where user = #{user} and password = #{password}")
    public User login(User user);
}
