package com.fjd.system.util;

import com.fjd.system.entity.RoleEntity;
import com.fjd.system.entity.UserEntity;
import com.fjd.system.info.RoleInfo;
import com.fjd.system.info.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConverUtil {

    static Logger logger = LoggerFactory.getLogger(Logger.class);
    /**
     * 集合转换
     * @param roleInfos
     * @return roleEntities
     */
    public static List<RoleEntity> roleInfosToRoleEntities(List<RoleInfo> roleInfos){

        List<RoleEntity> roleEntities = new ArrayList<>();

        for (RoleInfo roleInfo : roleInfos) {
            roleEntities.add(roleInfoToRoleEntity(roleInfo));
        }

        return roleEntities;
    }

    /**
     * 逆转 将RoleInfo转为 RoleEntity
     * @param roleInfo
     * @return RoleEntity
     */
    public static RoleEntity roleInfoToRoleEntity(RoleInfo roleInfo){
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRid(roleInfo.getRid());
        roleEntity.setRname(roleInfo.getRname());
        roleEntity.setRtype(roleInfo.getRtype());
        roleEntity.setRdesc(roleInfo.getRdesc());

        //解决鸡生蛋 蛋生鸡的问题；规避角色里面有用户，用户里面有角色
        //做一下判断，要求用户信息中的角色信息为null才进行，不然会陷入死循环
        if(null != roleInfo.getUsers() && roleInfo.getUsers().size() > 0
            && roleInfo.getUsers().get(0).getRoles() == null){
            roleEntity.setUsers(userInfosToUserEntities(roleInfo.getUsers()));
        }

        return roleEntity;
    }

    /**
     * roleEntity转换为roleInfo
     * @param roleEntity
     * @return
     */
    public static RoleInfo roleEntityToRoleInfo(RoleEntity roleEntity){
        RoleInfo roleInfo = new RoleInfo();

        roleInfo.setRid(roleEntity.getRid());
        roleInfo.setRname(roleEntity.getRname());
        roleInfo.setRtype(roleEntity.getRtype());
        roleInfo.setRdesc(roleEntity.getRdesc());

        return roleInfo;
    }

    /**
     * 将UserEntity 转换成 UserInfo
     * @param userEntity
     * @return UserInfo
     */

    //将userEntity 转换成 UserInfo
    //私有的方法是给自己用的 没有必要做非空判断，自己控制
    public static UserInfo userEntityToUserInfo(UserEntity userEntity){

        logger.info("system user service transform start : " + userEntity);

        UserInfo userInfo = new UserInfo();

        userInfo.setU1(userEntity.getU1());
        userInfo.setUaccount(userEntity.getUaccount());
        userInfo.setUpass(userEntity.getUpass());
        userInfo.setUdesc(userEntity.getUdesc());
        userInfo.setUid(userEntity.getUid());
        userInfo.setUname(userEntity.getUname());
        userInfo.setUphone(userEntity.getUphone());
        userInfo.setUemail(userEntity.getUemail());

        logger.info("system user service transform end : " + userInfo);
        return userInfo;
    }

    /**
     * 将UserInfo转为UserEntity
     * @param userInfo
     * @return UserEntity
     */
    public static UserEntity userInfoToUserEntity(UserInfo userInfo){

        logger.info("system user service reversion start : " + userInfo);

        UserEntity userEntity = new UserEntity();
        userEntity.setU1(userInfo.getU1());
        //没有密码环节
        //userEntity.setUpass(userInfo.getUpass());
        userEntity.setUdesc(userInfo.getUdesc());
        userEntity.setUaccount(userInfo.getUaccount());
        userEntity.setUid(userInfo.getUid());
        userEntity.setUemail(userInfo.getUemail());
        userEntity.setUphone(userInfo.getUphone());
        userEntity.setUname(userInfo.getUname());

        if(null != userInfo.getRoles()){
            userEntity.setRoles(roleInfosToRoleEntities(userInfo.getRoles()));
        }

        logger.info("system user service reversion end : " + userEntity);
        return userEntity;
    }

    /**
     * 链表的转换
     * @param userInfos
     * @return Entities
     */
    public static List<UserEntity> userInfosToUserEntities(List<UserInfo> userInfos){

        logger.info("system user service reversionList start : " + userInfos);

        List<UserEntity> userEntities = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            userEntities.add(userInfoToUserEntity(userInfo));
        }
        logger.info("system user service reversionList end : " + userEntities);

        return userEntities;
    }
}
