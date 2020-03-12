package com.learn.auth;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class PasswordEncoderTest {

    @Test
    public void encodeTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("password");

        System.out.println("password encode result: " + result);

        assertTrue(encoder.matches("password", result));
    }

}
