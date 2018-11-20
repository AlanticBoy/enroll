package com.enroll.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  21:27 2018/9/18
 * @ModefiedBy:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext_beans.xml");
        ComponentA componentA = context.getBean(ComponentA.class);
        componentA.print();
    }
}
