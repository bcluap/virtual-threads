package com.test;

import java.net.Socket;

public class TestWithStaticInit {

    static {
        try {
            Socket socket = new Socket("localhost", 12345);  // Fail fast
        } catch (Exception e) {
        }
    }

}
