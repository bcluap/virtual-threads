package com.test;

public class MainClass {

    public static String username;
    public static String password;

    public static void main(String[] args) {
        try {
            Thread.ofVirtual().start(() -> {
                System.out.println("If you see nothing after this, then we are locked up");
                new Test();
                System.out.println("Great, we are not locked up. You probably didnt have -Djdk.virtualThreadScheduler.parallelism=1");
            }).join();
        } catch (InterruptedException ex) {
        }
    }
}
