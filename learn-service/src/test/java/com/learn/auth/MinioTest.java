package com.learn.auth;

import io.minio.MinioClient;
import io.minio.ServerSideEncryption;
import io.minio.errors.*;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import javax.crypto.KeyGenerator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MinioTest {

    @Test
    public void uploadTest() throws InvalidPortException, InvalidEndpointException, IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, ErrorResponseException, NoResponseException, InvalidBucketNameException, XmlPullParserException, InternalException, RegionConflictException, InvalidArgumentException, InvalidResponseException {
        MinioClient minioClient = new MinioClient("http://101.132.110.185", 19000, "minioadmin", "minio-linux");

        if (!minioClient.bucketExists("test")) {
            minioClient.makeBucket("test");
        }

        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);

        Map<String, String> headerMap = new HashMap<>();

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);

        ServerSideEncryption sse = null;
        minioClient.putObject("test", "hello1",
                new ByteArrayInputStream(bytes), Long.valueOf(bytes.length), headerMap, sse,
                "text");

        InputStream inputStream = minioClient.getObject("test", "hello1");
//        System.out.println(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));
    }

}
