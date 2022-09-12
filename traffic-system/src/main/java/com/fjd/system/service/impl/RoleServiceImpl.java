package com.fjd.system.service.impl;

import com.fjd.system.entity.RoleEntity;
import com.fjd.system.info.RoleInfo;
import com.fjd.system.repository.RoleRepository;
import com.fjd.system.service.RoleService;
import com.fjd.system.util.ConverUtil;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public boolean addRole(RoleEntity roleEntity) {

        RoleInfo save = roleRepository.save(ConverUtil.roleEntityToRoleInfo(roleEntity));

        return null != save && save.getRid() != 0;
    }

    /**
     * 查询所有角色
     * @return list
     */
    @Override
    public List<RoleEntity> queryRoles() {

        List<RoleInfo> roles = roleRepository.findAll();

        return ConverUtil.roleInfosToRoleEntities(roles);
    }

}
