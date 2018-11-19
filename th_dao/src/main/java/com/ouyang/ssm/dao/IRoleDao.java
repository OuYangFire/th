package com.ouyang.ssm.dao;

import com.ouyang.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from ROLE where id in(select ROLEID from USERS_ROLE where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId);
}
