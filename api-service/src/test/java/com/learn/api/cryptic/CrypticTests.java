package com.learn.api.cryptic;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 23:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrypticTests {

    private static final Logger log = LoggerFactory.getLogger(CrypticTests.class);
    @Autowired
    private StringEncryptor stringEncryptor;

    private String pass = "";

    @Test
    public void testEncrypt() {
        log.info("encrypt: " + stringEncryptor.encrypt("password"));
    }

    @Test
    public void testDecrypt() {
        log.info("decrypt: " + stringEncryptor.decrypt("qa8tN9kgd7l78DtfdG8noFKJvC6r1l2E"));
    }

}
