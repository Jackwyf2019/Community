package com.isee.community.mapper;

import com.isee.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //当参数是一个类时可以用#{}获得属性
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void insert(User user);

    //参数不是类需要用@Param指定
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

}