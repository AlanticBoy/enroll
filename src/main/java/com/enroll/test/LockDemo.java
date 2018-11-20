package com.enroll.test;

import org.aspectj.runtime.internal.cflowstack.ThreadStack;
import org.junit.Test;
import sun.misc.Unsafe;

import javax.annotation.processing.Processor;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:50 2018/8/19
 * @ModefiedBy:
 */
public class LockDemo {

    @Test
    public void test() {
        LockDemo demo = new LockDemo();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfos) {
            System.out.println("ThreadId " + info.getThreadId() + "  ThreadName  " + info.getThreadName());
        }
        System.out.println(demo);
        demo.print("Hello", this);
    }

    public void print(String content, LockDemo demo) {
        System.out.println("  " + content);
        System.out.println("  " + demo);
    }

    @Test
    public void test2() {

    }
}
