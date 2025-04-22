package com.test;

import java.net.Socket;

public class TestWithStaticInit2 {

    static {
        try {
            Socket socket = new Socket("151.101.192.81", 443);  // Some BBC IP
        } catch (Exception e) {
        }
    }

}
