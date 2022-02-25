package com.example.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.entity.UserRolePO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolePOMapper extends BaseMapper<UserRolePO> {
    //给用户动态分配角色
    void assignRole(int userid, int roleid);
}
