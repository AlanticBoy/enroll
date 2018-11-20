package com.enroll.aspect;

import com.enroll.aspect.LogAspect;
import com.enroll.aspect.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:51 2018/9/15
 * @ModefiedBy:
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

}
