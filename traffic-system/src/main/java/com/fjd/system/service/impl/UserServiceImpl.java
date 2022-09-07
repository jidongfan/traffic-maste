package com.fjd.system.service.impl;

import com.fjd.api.commons.SystemUtils;
import com.fjd.system.entity.UserEntity;
import com.fjd.system.info.UserInfo;
import com.fjd.system.repository.UserRepository;
import com.fjd.system.service.UserService;
import com.fjd.system.web.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    final int ZERO = 0;
    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    /**
     * 添加用户
     * @param userEntity
     * @return true：保存成功
     */
    @Override
    public boolean addUser(UserEntity userEntity) {

        UserInfo user = null;
        logger.info("system user service adduser start : " + userEntity);
        logger.info("system user service adduser userRepository start ");
        try{
            user = userRepository.save(transform(userEntity));
            logger.info("system user service adduser userRepository save end ");
            logger.info("user:" + user);
        }catch (Exception exception){
            logger.error("system user service addUser fail" + exception);
            return false;
        }

        //long类型的默认值为0
        if(!SystemUtils.isNull(user) && user.getUid() != ZERO){
            logger.info("system user service addUser success");
            return true;
        }
        logger.error("system user service addUser fail");
        return false;
    }

    /**
     * 删除用户
     * @param uid 需要删除的id
     * @return true: 删除成功
     */
    @Override
    public boolean delUser(String uid) {

        //删除一条或者删除多条的业务逻辑
        String[] ids = uid.split(",");

        if(SystemUtils.isNull(ids) || ids.length == 0){
            return false;
        }

        //删除一条
        if(ids.length == 1){
            //有两种办法
            //方式一：先查询后更新（推荐）
            //把可能报异常的代码加上try catch
            try{
                //id是int转为long
                Long id = Long.parseLong(ids[0]);
                UserInfo userInfo = userRepository.findById(id).get();
                userInfo.setUstatus(1);
                userRepository.save(userInfo); //save 有就保存 没有就插入
                return true;
            }catch (Exception exception){
                return false;
            }
        }else { //删除多条
            try{
                Set<Long> sets = new HashSet<>();
                for (String id : ids) {
                    sets.add(Long.parseLong(id));
                }
                userRepository.updates(sets);
                return true;
            }catch (Exception exception){
                return false;
            }
        }
    }

    /**
     * 修改用户
     * @param userEntity  需要修改的信息
     * @return true:修改成功
     */
    @Override
    public boolean updUser(UserEntity userEntity) {

        //1.去数据库里面查询有没有这个记录
        userRepository.findById(userEntity.getUid()).get();
        //2.根据前端传来的信息去进行修改
        if(SystemUtils.isNullOrEmpty(userEntity.getUaccount())){
            
        }
        return false;
    }

    /**
     * 将UserEntity 转换成 UserInfo
     * @param userEntity
     * @return UserInfo
     */

    //将userEntity 转换成 UserInfo
    //私有的方法是给自己用的 没有必要做非空判断，自己控制
    private UserInfo transform(UserEntity userEntity){

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
}
