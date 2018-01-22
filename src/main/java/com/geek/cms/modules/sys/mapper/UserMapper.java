package com.geek.cms.modules.sys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}