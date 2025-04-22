package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {

    public static void main(String[] args) {
        doTest1();
        doTest2();
    }

    static void doTest1() {
        int threadCnt = Runtime.getRuntime().availableProcessors() - 1;
        System.out.println("Doing a test using " + threadCnt + " virtual threads");
        AtomicInteger cnt = new AtomicInteger(0);
        for (int i = 0; i < threadCnt; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("Testing with a static init doing IO");
                new TestWithStaticInit1();
                System.out.println("Great, we are not locked up");
                cnt.incrementAndGet();
            });
        }
        long start = System.currentTimeMillis();
        while (cnt.get() != threadCnt) {
            try {
                if (System.currentTimeMillis() - start > 10000) {
                    System.out.println("Gave up waiting for all virtual threads to finish");
                    System.exit(1);
                }
                System.out.println("Waiting for all virtual threads to finish");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
     static void doTest2() {
        int threadCnt = Runtime.getRuntime().availableProcessors();
        System.out.println("\n\n\nDoing a test using " + threadCnt + " virtual threads");
        AtomicInteger cnt = new AtomicInteger(0);
        for (int i = 0; i < threadCnt; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("Testing with a static init doing IO");
                new TestWithStaticInit2();
                System.out.println("Great, we are not locked up");
                cnt.incrementAndGet();
            });
        }
        long start = System.currentTimeMillis();
        while (cnt.get() != threadCnt) {
            try {
                if (System.currentTimeMillis() - start > 10000) {
                    System.out.println("Gave up waiting for all virtual threads to finish");
                    System.exit(1);
                }
                System.out.println("Waiting for all virtual threads to finish");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
