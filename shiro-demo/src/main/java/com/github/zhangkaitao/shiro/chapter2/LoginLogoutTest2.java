package com.github.zhangkaitao.shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest2 {

    protected void login(String configFile, String userName, String password) {
        //1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        subject.login(token);
    }

//    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        login("classpath:shiro-authenticator-all-success.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        //�õ�һ����ݼ��ϣ��������Realm��֤�ɹ��������Ϣ
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(2, principalCollection.asList().size());
    }
}
