package com.enroll.callBack;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:00 2018/8/22
 * @ModefiedBy:
 */
public class Personnnal {
    public void doSomething(CallBack callBack, String task) {
        // 总经理通过doSomething方法告诉员工要做什么
        System.out.println("总经理要你做" + task);

        String result = "做完了";

        // 当事情做完了我们就通过总经理公布的phoneCall方法通知总经理结果
        callBack.backResult(result);
    }
}
