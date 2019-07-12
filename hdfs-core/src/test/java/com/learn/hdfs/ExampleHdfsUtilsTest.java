package com.learn.hdfs;

import org.apache.hadoop.fs.*;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class ExampleHdfsUtilsTest {

    @Test
    public void readAllTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();

        RemoteIterator<LocatedFileStatus> remoteIterator = fileSystem.listFiles(new Path("/"), true);

        while (remoteIterator.hasNext()) {
            LocatedFileStatus locatedFileStatus = remoteIterator.next();

            System.out.println(locatedFileStatus.getPath());
        }
    }

    @Test
    public void readTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        try (FSDataInputStream fsDataInputStream = fileSystem.open(new Path("/user/hadoop/test1/Hello.txt"))) {
            byte[] bytes = new byte[1024];
            fsDataInputStream.read(bytes);
            System.out.println("content: " + new String(bytes, StandardCharsets.UTF_8));
        }
    }

    @Test
    public void createAndWriteTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        try (FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/user/hadoop/test1/Hello.txt"))) {
            fsDataOutputStream.write("Hello World, this is test content.".getBytes(StandardCharsets.UTF_8));
            fsDataOutputStream.flush();
        }
    }

    @Test
    public void mkdirTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        boolean isMake = fileSystem.mkdirs(new Path("/user/hadoop/test3"));
        Assert.assertEquals(true, isMake);
    }

    @Test
    public void renameTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        boolean isRename = fileSystem.rename(new Path("/user/hadoop/test3"), new Path("/user/hadoop/test5"));
        Assert.assertEquals(true, isRename);
    }

    @Test
    public void deleteTest()  throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        boolean isDelete = fileSystem.delete(new Path("/user/hadoop/test5"), true);
        Assert.assertEquals(true, isDelete);
    }

    @Test
    public void concatTest() throws Exception {
        FileSystem fileSystem = LearnHdfsUtils.getFileSystem();
        fileSystem.concat(new Path("/user/hadoop/test/10338_100.png"), new Path[]{new Path("/user/hadoop/test/10338_100.png")});
    }

}
