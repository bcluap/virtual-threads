package com.test;

public class MainClass {

    public static void main(String[] args) {
        try {
            Thread.ofVirtual().start(() -> {
                System.out.println("Testing with normal method doing IO");
                new TestNonStaticInit();
                System.out.println("Great, we are not locked up");
            }).join();
        } catch (InterruptedException ex) {
        }
        try {
            Thread.ofVirtual().start(() -> {
                System.out.println("Testing with a static init doing IO");
                new TestWithStaticInit();
                System.out.println("Great, we are not locked up");
            }).join();
        } catch (InterruptedException ex) {
        }
    }
}
