package com.fjd.system.service;

import com.fjd.api.commons.SystemUtils;
import com.fjd.system.entity.UserEntity;
import com.fjd.system.info.UserInfo;
import com.fjd.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
