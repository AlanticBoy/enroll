package com.enroll.callBack;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:00 2018/8/22
 * @ModefiedBy:
 */
public class Manager implements CallBack{

    public Manager(Personnnal personnnal) {
      personnnal.doSomething(this,"整理文件");
    }

    @Override
    public void backResult(String result) {
        System.out.println("  事情   "+result);
    }
}
