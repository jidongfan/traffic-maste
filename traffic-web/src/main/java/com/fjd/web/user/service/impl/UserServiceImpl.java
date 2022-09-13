package com.fjd.web.user.service.impl;

import com.fjd.web.user.dao.UserRepository;
import com.fjd.web.user.entity.UserEntity;
import com.fjd.web.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //日志类
    final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity login(UserEntity userEntity){

        //认证过程中，对于密码没有对密码进行加密，即使加密了也不要打印
        logger.info("UserServiceImpl login start " + userEntity);

        UserEntity ue = userRepository.findByUserNameAndUserPass(userEntity.getUserName(), userEntity.getUserPass());

        logger.info("UserServiceImpl login end " + ue);

        return ue;
    }

}
