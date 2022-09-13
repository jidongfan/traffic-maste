package com.fjd.api.commons.util;

import com.fjd.api.code.UserAuthCode;
import org.apache.catalina.User;
import org.yaml.snakeyaml.util.ArrayUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    /**
     * 获取我们指定的cookie信息
     * @param request
     * @Param key cookie的key值 key不可谓null
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        if(null != cookies && cookies.length > UserAuthCode.USER_AUTH_INT_ZERO){
            for (Cookie ck : cookies) {
                if(key.equals(ck.getName())){
                    return ck.getValue();
                }
            }
        }

        return null;
    }

    /**
     * 给指定的cookie设置信息
     * @param cookie
     * @param uri 路径
     * @param maxAge 最大时间
     * @param domain 域名
     */
    public static void setCookieInfos(Cookie cookie, String uri, int maxAge, String domain){
        cookie.setDomain(domain);
        cookie.setPath(uri);
        cookie.setMaxAge(maxAge);
    }

    /**
     * 给 /（根目录）指定我们的cookie信息
     * @param key
     * @param value
     * @param domain
     * @param maxAge
     * @return
     */
    public static Cookie setCookieRoot(String key, String value, String domain, int maxAge){
        Cookie cookie = new Cookie(key, value);
        setCookieInfos(cookie, UserAuthCode.COOKIE_ROOT_PATH, maxAge, domain);
        return cookie;
    }

    /**
     * 给指定uri目录 指定我们的cookie信息
     * @param key 键
     * @param value 值
     * @param uri 我们给指定path 下放cookie
     * @param domain 域名
     * @param maxAge 超时时间
     * @return
     */
    public static Cookie setCookieRoot(String key, String value, String uri, String domain, int maxAge){
        Cookie cookie = new Cookie(key, value);
        setCookieInfos(cookie, uri, maxAge, domain);
        return cookie;
    }

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return true 是
     */
    public static boolean isAjax(HttpServletRequest request){

        boolean result = false;
        //判断是否是Ajax请求
        if(UserAuthCode.AJAX_XMLHTTPREQUEST.equals(request.getHeader(UserAuthCode.X_REQUESTED_WITH))){
            result = true;
        }

        return result;
    }


}
