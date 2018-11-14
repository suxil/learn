package com.learn.service;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Test;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/27 0027 17:01
 */
public class Tests {

    private static PooledPBEStringEncryptor encryptor = null;

    public static StringEncryptor stringEncryptor() {
        encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("api-web-app");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void encrypt(String val) {
        System.out.println(encryptor.encrypt(val));
    }

    public static void decrypt(String dec) {
        System.out.println(encryptor.decrypt(dec));
    }

    @Test
    public void encrypt() {
        stringEncryptor();

        encrypt("jdbc:mysql://101.132.110.185:3306/learn?verifyServerCertificate=false&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true");

        encrypt("learn");
        encrypt("learn-m");
        encrypt("learn-r");
        encrypt("com.mysql.jdbc.Driver");
        encrypt("101.132.110.185");
        encrypt("16379");
        encrypt("5672");


        System.out.println("----------------------");

        decrypt("j8Fec2fHQLNQH03QdveIYw==");

        decrypt("oeXj4jQEq63fVOUR5FgGbUKiUOXJKJU2");
        decrypt("3rLcn+OqHEA5Te56Gz0fPA==");
        decrypt("vtHuhEy7AE1HvOCdJ4rSeQ==");
        decrypt("Kh6/jr5icsEsrdz/lEsEaN39aQUeJiNc");
        decrypt("3rLcn+OqHEA5Te56Gz0fPA==");
        decrypt("YJ/B/MpRnc4ymlzlsgvbJQ==");
    }

}
