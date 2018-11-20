package com.enroll.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  20:45 2018/9/15
 * @ModefiedBy:
 */
@Aspect
public class LogAspect {

    public final static String POINT_CUT = "execution(public int com.enroll.aspect.MathCalculator.getResult(int,int))";

    @Pointcut(POINT_CUT)
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "  before start  ");
    }

    @Around("pointCut()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + "  around execute   ");
        Object []args=joinPoint.getArgs();
       return joinPoint.proceed(args);

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "  after  execute   ");
    }

    @AfterReturning("pointCut()")
    public void doAfterReturn(){
        System.out.println(" return  ");
    }
}
