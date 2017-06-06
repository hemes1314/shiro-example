package com.github.zhangkaitao.shiro.chapter3;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import com.github.zhangkaitao.shiro.chapter2.LoginLogoutTest2;

public class RoleTest extends LoginLogoutTest2{

    @Test
    public void testHasRole() {
        login("classpath:shiro-role.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();
        //�ж�ӵ�н�ɫ��role1
        Assert.assertTrue(subject.hasRole("role1"));
        //�ж�ӵ�н�ɫ��role1 and role2
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        //�ж�ӵ�н�ɫ��role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
        
        
        // Throws Exception
        //����ӵ�н�ɫ��role1  
        subject.checkRole("role1");  
        //����ӵ�н�ɫ��role1 and role3 ʧ���׳��쳣  
        subject.checkRoles("role1", "role3");  
    }
}
