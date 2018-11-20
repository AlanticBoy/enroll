package com.enroll.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:13 2018/9/16
 * @ModefiedBy:
 */
public class CgLibProxy implements MethodInterceptor {

   private Enhancer enhancer=new Enhancer();

   public Object getProxy(Class clazz){
       enhancer.setSuperclass(clazz);
       enhancer.setCallback(this);
       return enhancer.create();
   }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+"  before method ");
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println(method.getName()+"  after method ");
        return result;
    }
}
