package com.fjd.system.service;

import com.fjd.api.commons.SystemUtils;
import com.fjd.system.entity.UserEntity;
import com.fjd.system.info.UserInfo;
import com.fjd.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 添加用户
     * @param userEntity  前端传过来的参数信息
     * @return true:添加保存成功
     */
    public boolean addUser(UserEntity userEntity);

    /**
     * 删除用户
     * @param uid
     * @return true：删除成功
     */
    public boolean delUser(String uid);

    /**
     * 修改用户
     * @param userEntity  前端传过来的参数信息
     * @return true:修改成功
     */
    public boolean updUser(UserEntity userEntity);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    public List<UserEntity> findAllUser();

    /**
     * 条件查询
     * @param userEntity
     * @return 用户列表
     */
    public List<UserEntity> findAllUserByWhere(UserEntity userEntity);

    /**
     * 根据时间条件查询
     * @param t1
     * @param t2
     * @return
     */
    public List<UserEntity> findUsersByTime(String t1, String t2);

    /**
     * 分页查询
     * 条件查询
     * @param userEntity
     * @return
     */
    public Map<String, Object> queryUsers(UserEntity userEntity);
}
