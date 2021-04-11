package io.github.suxil.service;

import io.minio.MinioClient;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MinioTest {

    @Test
    public void uploadTest() throws Exception {
        MinioClient minioClient = new MinioClient("http://101.132.110.185", 19000, "minioadmin", "minio-linux");

        if (!minioClient.bucketExists("test")) {
            minioClient.makeBucket("test");
        }

        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);

        minioClient.putObject("test", "hello1", new ByteArrayInputStream(bytes), null);

        InputStream inputStream = minioClient.getObject("test", "hello1");
//        System.out.println(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));
    }

}
