package com.fjd.system.web;

import com.fjd.api.code.SystemCode;
import com.fjd.api.commons.ResponseResult;
import com.fjd.api.commons.ResponseResultFactory;
import com.fjd.api.commons.SystemUtils;
import com.fjd.system.entity.UserEntity;
import com.fjd.system.info.UserInfo;
import com.fjd.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    //在哪个类里打印的日志
    final Logger logger = LoggerFactory.getLogger(UserController.class);

    final long UPD_USER_ZERO = 0;  //代表id为0
    final static int NAME_LENGTH = 3;  //用户名的长度
    final static int ACCOUNT_LENGTH = 6;  //账号的长度
    final static int PASS_LENGTH = 6;  //密码的长度

    @Autowired
    UserService userService;

    /**
     * 添加用户的请求
     * @param userEntity
     * @return 是否成功
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ResponseResult addUser(UserEntity userEntity){

        logger.info("system user addUser start");
        //参数为null
        if(SystemUtils.isNull(userEntity)){
            logger.error("system user addUser UserEntity is null");
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PARAM_NULL);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //用户名为null
        if(SystemUtils.isNullOrEmpty(userEntity.getUname())){
            logger.error("system user addUser uname is null");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL, SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL_MSG);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //账号
        if(SystemUtils.isNullOrEmpty(userEntity.getUaccount())){
            logger.error("system user addUser uaccount is null");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_NULL);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //密码
        if(SystemUtils.isNullOrEmpty(userEntity.getUpass())){
            logger.error("system user addUser upass is null");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_NULL);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //手机是否为null
        if(SystemUtils.isNullOrEmpty(userEntity.getUphone())){
            logger.error("system user addUser uphone is null");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PHONE_NULL);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //用户名小于3字符长度
        if(userEntity.getUname().trim().length() < NAME_LENGTH){
            logger.error("system user addUser uname length < 3");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_SIZE);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //账号不小于6字符
        if(userEntity.getUaccount().trim().length() < ACCOUNT_LENGTH){
            logger.error("system user addUser uaccount length < 6");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_SIZE);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //密码不小于6字符
        if(userEntity.getUpass().trim().length() < PASS_LENGTH){
            logger.error("system user addUser upass length < 6");
            logger.info("param : "+userEntity);
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_SIZE);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }

        //在这里吧密码记录成明文，违反安全规范，上面即使日志打印出来也没用，因为本来就是错误的，没存进去才打印日志
        //最好还是在打印日志的时候 UserEntity的toString中不要有upass，以防万一
        //敏感的信息一定不能通过日志记录下来，账户 手机号 密码 用户名 或者只记录几位
        //密码的加密操作
        logger.info("system user addUser upass digest");
        userEntity.setUpass(DigestUtils.md5DigestAsHex(userEntity.getUpass().getBytes()));

        //保存用户信息
        logger.info("system user addUser userService addUser start");
        boolean result = userService.addUser(userEntity);
        logger.info("system user addUser userService addUser end : " + result);

        return returnResponseResult(result, SystemCode.SYSTEM_USER_ERROR_ADD_FAIL);
    }

    /**
     * 删除用户的请求
     * @param uid = "1" 删除一个; uid = "1,2,3" 删除多个用逗号分隔
     * @return 是否成功
     */
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public ResponseResult delUser(String uid){

        logger.info("system user delUser start");

        if(SystemUtils.isNullOrEmpty(uid)){
            logger.error("system user delUser uid is null");
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_DEL_FAIL_UID_NULL);
            logger.info("system user delUser return msg : " + responseResult);
            return responseResult;
        }

        //简单的逻辑判断；1.可以在这里判断；2.交给业务层判断
        logger.info("system user delUser UserService start");
        boolean result = userService.delUser(uid);
        logger.info("system user delUser UserService end " + result);

        return returnResponseResult(result, SystemCode.SYSTEM_USER_ERROR_DEL_FAIL);
    }

    /**
     * 更新用户信息
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/updUser",method = RequestMethod.POST)
    public ResponseResult updUser(UserEntity userEntity){

        logger.info("system user updUser start");
        //参数为null
        if(SystemUtils.isNull(userEntity)){
            logger.error("system user updUser UserEntity is null");
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_UPD_FAIL_PARAM_NULL);
            logger.info("system user updUser return msg : " + responseResult);
            return responseResult;
        }
        //没有传id
        if(SystemUtils.isNull(userEntity.getUid()) || userEntity.getUid() == UPD_USER_ZERO){
            logger.error("system user updUser uid is null");
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_UPD_FAIL_UID_NULL);
            logger.info("system user updUser uid msg : " + responseResult);
            return responseResult;
        }

        logger.info("system user updUser service start :" + userEntity);
        boolean result = userService.updUser(userEntity);
        logger.info("system user updUser service end :" + result);

        logger.info("system user updUser end");
        return returnResponseResult(result, SystemCode.SYSTEM_USER_ERROR_UPD_FAIL);
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
