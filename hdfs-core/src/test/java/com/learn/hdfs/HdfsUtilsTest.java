package com.learn.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;

public class HdfsUtilsTest {

    @Test
    public void readTest() throws Exception {
        String file = "hdfs://192.168.27.132:8020/word.txt";
        FileSystem fileSystem = FileSystem.get(URI.create(file), new Configuration());
        FSDataInputStream is = fileSystem.open(new Path(file));
        byte[] buff = new byte[1024];
        int length = 0;
        // 打印每一行文字内容
        while ((length = is.read(buff)) != -1) {
            System.out.println(new String(buff, 0, length));
        }
    }

    @Test
    public void mkdirTest() throws Exception {
        String file = "hdfs://192.168.27.132:8020/";
        FileSystem fileSystem = FileSystem.get(URI.create(file), new Configuration());
        fileSystem.mkdirs(new Path("/test"));
    }

}
