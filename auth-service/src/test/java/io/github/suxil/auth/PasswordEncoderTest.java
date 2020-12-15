package io.github.suxil.auth;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class PasswordEncoderTest {

    @Test
    public void encodeTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("password");

        System.out.println("password encode result: " + result);

        boolean checkResult = encoder.matches("password", result);
        assertTrue(encoder.matches("password", result));
    }

}
