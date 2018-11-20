package com.enroll.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  14:41 2018/8/19
 * @ModefiedBy:
 */
public class Counter {
    private AtomicInteger ai=new AtomicInteger(0);
    private int i;

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        List<Thread> threadList=new ArrayList<>(1000);
        final Counter cas=new Counter();
        for (int k=0;k<300;k++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                  cas.count();
                  cas.safeCount();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(thread);
        }
        for (Thread td:threadList){
            td.start();
        }
        for (Thread td:threadList){
            try {
                td.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.ai.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    private void safeCount(){
        for (;;){
            int ret=ai.get();
            boolean suc=ai.compareAndSet(ret,++ret);
            if(suc){
                break;
            }
        }
    }

    private void count(){
        i++;
    }
}
