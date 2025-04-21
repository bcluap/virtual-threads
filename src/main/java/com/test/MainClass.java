package com.test;

public class MainClass {

    public static void main(String[] args) {
        try {
            Thread.ofVirtual().start(()->{
                new Test();
            }).join();
        } catch (InterruptedException ex) {
        }
    }
}
