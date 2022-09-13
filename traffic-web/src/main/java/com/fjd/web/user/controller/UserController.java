package com.fjd.web.user.controller;

import com.fjd.api.code.SystemCode;
import com.fjd.web.user.entity.UserEntity;
import com.fjd.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(UserEntity userEntity, HttpSession session){

        //非空校验以及相关判断；可以参照traffic-system模块中的用户添加，后面再补

        UserEntity ue = userService.login(userEntity);

        if(null == ue){ //没找到

            return SystemCode.USER_WEB_ERROR_LOGIN_FAIL + "";
        }else {
            session.setAttribute("uid", ue.getUid());
            return SystemCode.USER_WEB_ERROR_LOGIN_SUCCESS + ": " + session.getId();

        }

    }

    @RequestMapping("/testSession")
    public String testCookie(HttpSession session){

       return session.getId();
    }
}
