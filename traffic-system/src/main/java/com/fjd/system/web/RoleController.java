package com.fjd.system.web;

import com.fjd.api.code.SystemCode;
import com.fjd.api.commons.ResponseResult;
import com.fjd.api.commons.ResponseResultFactory;
import com.fjd.system.entity.RoleEntity;
import com.fjd.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    
    final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    /**
     * 添加角色
     * @param roleEntity
     * @return 是否成功
     */
    @RequestMapping("/addRole")
    public ResponseResult addRole(RoleEntity roleEntity){

        boolean result = roleService.addRole(roleEntity);

        return returnResponseResult(result, SystemCode.SYSTEM_ROLE_ERROR_ADD_FAIL);
    }

    @RequestMapping("/queryAllRoles")
    public ResponseResult queryAllRoles(){

        List<RoleEntity> roleEntities = roleService.queryRoles();

        return ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, roleEntities);
    }

    /**
     * 返回结构视图
     * @param result
     * @return
     */
    private ResponseResult returnResponseResult(boolean result, String code) {
        ResponseResult responseResult;
        if(result){
            responseResult = ResponseResultFactory.buildResponseResult();
        }else {
            responseResult = ResponseResultFactory.buildResponseResult(code);
            logger.error("system user returnResponseResult fail : " + code);
        }
        logger.info("system user returnResponseResult end , return :" + responseResult);
        return responseResult;
    }
}

