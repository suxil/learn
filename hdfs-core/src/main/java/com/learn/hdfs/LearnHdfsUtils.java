package com.learn.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class LearnHdfsUtils {

    public static final String HDFS_PREFIX = "hdfs://";
    public static final String WEBHDFS_PREFIX = "web" + HDFS_PREFIX;
    public static final String HDFS_BASE_URI = "192.168.80.131:9870";
    public static final String HDFS_READ_BASE_URI = "192.168.80.131:9870";
    public static final String HDFS_WRITE_BASE_URI = "192.168.80.131:9864";

    private static final String USER = "hadoop";
    private static FileSystem FILE_SYSTEM;

    static {
        try {
            FILE_SYSTEM = FileSystem.get(new URI(WEBHDFS_PREFIX + HDFS_BASE_URI), new Configuration(), USER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 hdfs FileSystem
     * @return
     */
    public static FileSystem getFileSystem() {
        return FILE_SYSTEM;
    }

    /**
     * 列出所有DataNode的名字信息
     */
    public static void listDataNodeInfo() {
        try {
            DistributedFileSystem distributedFileSystem = (DistributedFileSystem) FILE_SYSTEM;
            DatanodeInfo[] dataNodeStats = distributedFileSystem.getDataNodeStats();

            System.out.println("List of all the dataNode in the HDFS cluster:");
            for (DatanodeInfo datanodeInfo : dataNodeStats) {
                String hostName = datanodeInfo.getHostName();
                System.out.println(hostName);
            }
            System.out.println(FILE_SYSTEM.getUri().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查文件或者文件夹是否存在
     * @param filePath
     * @return
     */
    public static boolean checkExist(String filePath) {
        try {
            Path f = new Path(filePath);
            return FILE_SYSTEM.exists(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取文件状态
     * @param filePath
     * @return
     */
    public static FileStatus getFileStatus(String filePath) {
        Path p = new Path(filePath);
        try {
            FileStatus fileStatus = FILE_SYSTEM.getFileStatus(p);
            return fileStatus;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建文件夹, 如果路径不存在就创建文件夹
     * @param dirName
     * @return
     */
    public static boolean mkdirs(String dirName) {
        if (checkExist(dirName))
            return true;
        try {
            Path f = new Path(dirName);
            return FILE_SYSTEM.mkdirs(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 创建一个空文件
     * @param filePath 文件的完整路径名称
     * @return
     */
    public static boolean makeFile(String filePath) {
        Path f = new Path(filePath);
        try {
            FILE_SYSTEM.create(f, true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 上传文件, 文件格式是 UTF-8
     * @param filePath
     * @param bytes
     * @return
     */
    public static boolean uploadFile(String filePath, byte[] bytes) {
        Path f = new Path(filePath);
        try (FSDataOutputStream os = FILE_SYSTEM.create(f, true)) {
            os.write(bytes);
            os.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 下载文件
     * @param filePath
     * @return
     */
    public static byte[] downloadFile(String filePath) {
        Path f = new Path(filePath);
        try (FSDataInputStream dis = FILE_SYSTEM.open(f)) {
            return IOUtils.toByteArray(dis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 复制文件到指定目标文件
     * @param srcPath 源文件路径
     * @param targetPath 目标文件路径
     * @return
     */
    public static boolean copy(String srcPath, String targetPath) {
        byte[] bytes = downloadFile(srcPath);
        return uploadFile(targetPath, bytes);
    }

    /**
     * 移动文件或者文件夹
     * @param srcPath 源文件路径
     * @param dstPath 目标文件路径
     */
    public static boolean move(String srcPath, String dstPath) {
        Path sPath = new Path(srcPath);
        Path dPath = new Path(dstPath);
        try {
            return FILE_SYSTEM.rename(sPath, dPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除文件或者文件夹
     * @param filePath
     */
    public static boolean delete(String filePath) {
        Path p = new Path(filePath);
        try {
            return FILE_SYSTEM.delete(p, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将一个字符串写入某个文件
     * @param filePath 要保存的路径
     * @param content 要保存的字符串
     */
    public static boolean writerString(String filePath, String content) {
        Path f = new Path(filePath);
        try (
                FSDataOutputStream fsDataOutputStream = FILE_SYSTEM.create(f, true);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
                ) {
            writer.write(content);
            writer.flush();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 读取文件为字符串
     * @param filePath
     * @return
     */
    public static String readerString(String filePath) {
        byte[] bytes = downloadFile(filePath);

        String content = new String(bytes, StandardCharsets.UTF_8);
        return content;
    }

}
