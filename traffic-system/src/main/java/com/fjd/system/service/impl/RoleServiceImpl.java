package com.fjd.system.service.impl;

import com.fjd.system.entity.RoleEntity;
import com.fjd.system.info.RoleInfo;
import com.fjd.system.repository.RoleRepository;
import com.fjd.system.service.RoleService;
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

        RoleInfo save = roleRepository.save(transform(roleEntity));

        return null != save && save.getRid() != 0;
    }

    /**
     * 查询所有角色
     * @return list
     */
    @Override
    public List<RoleEntity> queryRoles() {

        List<RoleInfo> roles = roleRepository.findAll();

        return reversionList(roles);
    }

    /**
     * 集合转换
     * @param roleInfos
     * @return roleEntities
     */
    private List<RoleEntity> reversionList(List<RoleInfo> roleInfos){

        List<RoleEntity> roleEntities = new ArrayList<>();

        for (RoleInfo roleInfo : roleInfos) {
            roleEntities.add(reversion(roleInfo));
        }

        return roleEntities;
    }

    /**
     * 逆转 将RoleInfo转为 RoleEntity
     * @param roleInfo
     * @return RoleEntity
     */
    private RoleEntity reversion(RoleInfo roleInfo){
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRid(roleInfo.getRid());
        roleEntity.setRname(roleInfo.getRname());
        roleEntity.setRtype(roleInfo.getRtype());
        roleEntity.setRdesc(roleInfo.getRdesc());

        return roleEntity;
    }

    /**
     * roleEntity转换为roleInfo
     * @param roleEntity
     * @return
     */
    private RoleInfo transform(RoleEntity roleEntity){
        RoleInfo roleInfo = new RoleInfo();

        roleInfo.setRid(roleEntity.getRid());
        roleInfo.setRname(roleEntity.getRname());
        roleInfo.setRtype(roleEntity.getRtype());
        roleInfo.setRdesc(roleEntity.getRdesc());

        return roleInfo;
    }
}
