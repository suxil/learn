package io.github.suxil.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    @Test
    public void encodeTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("password");

        System.out.println("password encode result: " + result);

        boolean checkResult = encoder.matches("password", result);
        Assertions.assertTrue(encoder.matches("password", result));
    }

}
