package com.test;

import java.net.Socket;

public class TestNonStaticInit {

    public TestNonStaticInit() {
        try {
            Socket socket = new Socket("localhost", 12345);  // Fail fast
        } catch (Exception e) {
        }
    }
}
