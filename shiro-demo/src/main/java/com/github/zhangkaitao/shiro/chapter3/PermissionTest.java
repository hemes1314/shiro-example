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
        //�ж�ӵ��Ȩ�ޣ�user:create
        Assert.assertTrue(subject.isPermitted("user:create"));
        //�ж�ӵ��Ȩ�ޣ�user:update and user:delete
        Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));
        //�ж�û��Ȩ�ޣ�user:view
        Assert.assertFalse(subject.isPermitted("user:view"));
        
        // �׳��쳣
//        //����ӵ��Ȩ�ޣ�user:create
//        subject().checkPermission("user:create");
//        //����ӵ��Ȩ�ޣ�user:delete and user:update
//        subject().checkPermissions("user:delete", "user:update");
//        //����ӵ��Ȩ�ޣ�user:view ʧ���׳��쳣
//        subject().checkPermissions("user:view");
    }
}
