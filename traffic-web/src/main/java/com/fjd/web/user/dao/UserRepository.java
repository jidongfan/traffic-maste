package com.fjd.web.user.dao;

import com.fjd.web.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByUserNameAndUserPass(String userName, String userPass);
}
