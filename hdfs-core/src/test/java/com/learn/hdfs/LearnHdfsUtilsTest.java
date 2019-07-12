package com.learn.hdfs;

import org.apache.hadoop.fs.FileStatus;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class LearnHdfsUtilsTest {

    /**
     * 列出所有DataNode的名字信息
     */
    @Test
    public void listDataNodeInfoTest() {
        LearnHdfsUtils.listDataNodeInfo();
    }

    /**
     * 检查文件或者文件夹是否存在
     */
    @Test
    public void checkExistTest() {
        String existFilePath = "/user/hadoop/test1";
        String notExistFilePath = "/user/hadoop/test7";

        boolean isExist = LearnHdfsUtils.checkExist(existFilePath);
        boolean isNotExist = LearnHdfsUtils.checkExist(notExistFilePath);

        Assert.assertEquals(true, isExist);
        Assert.assertEquals(false, isNotExist);
    }

    /**
     * 获取文件状态
     */
    @Test
    public void getFileStatusTest() {
        String filePath = "/user/hadoop/test1";

        FileStatus fileStatus = LearnHdfsUtils.getFileStatus(filePath);

        Assert.assertNotNull(fileStatus);
    }

    /**
     * 创建文件夹, 如果路径不存在就创建文件夹
     */
    @Test
    public void mkdirsTest() {
        String filePath = "/user/hadoop/test3/test";

        boolean isMkdir = LearnHdfsUtils.mkdirs(filePath);

        Assert.assertEquals(true, isMkdir);
    }

    /**
     * 创建一个空文件
     */
    @Test
    public void makeFileTest() {
        String filePath = "/user/hadoop/test3/testFile";

        boolean isMakeFile = LearnHdfsUtils.makeFile(filePath);

        Assert.assertEquals(true, isMakeFile);
    }

    /**
     * 上传文件
     */
    @Test
    public void uploadFileTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String content = "test";

        LearnHdfsUtils.uploadFile(filePath, content.getBytes(StandardCharsets.UTF_8));

        String result = LearnHdfsUtils.readerString(filePath);

        Assert.assertEquals(content, result);
    }

    /**
     * 下载文件
     */
    @Test
    public void downloadFileTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String content = "test";

        byte[] bytes = LearnHdfsUtils.downloadFile(filePath);
        String result = new String(bytes, StandardCharsets.UTF_8);

        Assert.assertEquals(content, result);
    }

    /**
     * 复制文件到指定目录
     */
    @Test
    public void copyTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String tarFilePath = "/user/hadoop/test3/hello_test1";

        boolean isCopy = LearnHdfsUtils.copy(filePath, tarFilePath);

        Assert.assertEquals(true, isCopy);
    }

    /**
     * 移动文件或者文件夹
     */
    @Test
    public void moveTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String tarFilePath = "/user/hadoop/test3/hello_test1";

        boolean isMove = LearnHdfsUtils.move(filePath, tarFilePath);

        Assert.assertEquals(true, isMove);
    }

    /**
     * 删除文件或者文件夹
     */
    @Test
    public void deleteTest() {
        String filePath = "/user/hadoop/test3/hello_test";

        boolean isDelete = LearnHdfsUtils.delete(filePath);

        Assert.assertEquals(true, isDelete);
    }

    /**
     * 将一个字符串写入某个文件
     */
    @Test
    public void writerStringTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String content = "test";

        boolean isWriter = LearnHdfsUtils.writerString(filePath, content);

        Assert.assertEquals(true, isWriter);
    }

    /**
     * 读取文件为字符串
     */
    @Test
    public void readerStringTest() {
        String filePath = "/user/hadoop/test3/hello_test";
        String content = "test";

        String result = LearnHdfsUtils.readerString(filePath);

        Assert.assertEquals(content, result);
    }

}
