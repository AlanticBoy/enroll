package com.enroll.cglib;

import org.junit.Test;
import org.springframework.aop.framework.AopProxy;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:22 2018/9/16
 * @ModefiedBy:
 */
public class Factory {
    @Test
    public void test() {
        CgLibProxy proxy = new CgLibProxy();
        UserManager manager = (UserManager) proxy.getProxy(UserManager.class);
        manager.function();
        manager.method();
        /*AopProxy*/
    }
}
