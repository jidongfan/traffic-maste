package com.fjd.web.user.service;

import com.fjd.web.user.entity.UserEntity;

public interface UserService {

    /**
     * 根据用户名密码查询这个用户
     * @param userEntity
     * @return
     */
    public UserEntity login(UserEntity userEntity);
}
