package com.egeo.back.user.web.interceptor;

/**
 * 用于controller，注入login信息
 */
public class LoginContext {
    //必须登录
    static boolean required=true;

    static boolean isAjax=true;
}