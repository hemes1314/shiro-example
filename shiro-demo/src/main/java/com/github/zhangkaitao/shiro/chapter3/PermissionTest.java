package com.github.zhangkaitao.shiro.chapter3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import com.github.zhangkaitao.shiro.chapter2.LoginLogoutTest2;

public class PermissionTest extends LoginLogoutTest2 {

    @Test
    public void testIsPermitted() {
        login("classpath:shiro-permission.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();
        //判断拥有权限：user:create
        Assert.assertTrue(subject.isPermitted("user:create"));
        //判断拥有权限：user:update and user:delete
        Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));
        //判断没有权限：user:view
        Assert.assertFalse(subject.isPermitted("user:view"));
        
        // 抛出异常
//        //断言拥有权限：user:create
//        subject().checkPermission("user:create");
//        //断言拥有权限：user:delete and user:update
//        subject().checkPermissions("user:delete", "user:update");
//        //断言拥有权限：user:view 失败抛出异常
//        subject().checkPermissions("user:view");
    }
}
