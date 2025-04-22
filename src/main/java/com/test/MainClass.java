package com.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        doTest1();
        doTest2();
    }

    static void doTest1() throws InterruptedException {
        int threadCnt = Runtime.getRuntime().availableProcessors() - 1;
        System.out.println("Doing doTest1 using " + threadCnt + " virtual threads");
        AtomicInteger cnt = new AtomicInteger(0);
        for (int i = 0; i < threadCnt; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("doTest1: Testing with a static init doing IO");
                new TestWithStaticInit1();
                System.out.println("doTest1: Great, we are not locked up");
                cnt.incrementAndGet();
            });
        }

        Thread.sleep(5000);

        Thread.ofVirtual().start(() -> {
            System.out.println("doTest1: Great, I was scheduled");
        }).join();
    }

    static void doTest2() throws InterruptedException {
        int threadCnt = Runtime.getRuntime().availableProcessors();
        System.out.println("\n\n\nDoing doTest2 using " + threadCnt + " virtual threads");
        AtomicInteger cnt = new AtomicInteger(0);
        for (int i = 0; i < threadCnt; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("doTest2: Testing with a static init doing IO");
                new TestWithStaticInit2();
                System.out.println("doTest2: Great, we are not locked up");
                cnt.incrementAndGet();
            });
        }

        Thread.sleep(5000);

        Thread.ofVirtual().start(() -> {
            System.out.println("doTest2: Great, I was scheduled");
        }).join();
    }
}
