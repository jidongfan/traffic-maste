package com.fjd.system.service;


import com.fjd.system.entity.RoleEntity;

import java.util.List;

public interface RoleService {

    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    public boolean addRole(RoleEntity roleEntity);

    /**
     * 查询角色信息
     * @return  角色列表
     */
    public List<RoleEntity> queryRoles();

}
