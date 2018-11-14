package com.learn.core.utils;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOUtils {

    public static final String ENCODE = "UTF-8";
    private static final String PATH_PREFIX = "src/main/resources/";

    /**
     * 通过文件名获取一个file
     * @param fileName
     * @return
     */
    public static File getFile(String fileName) {
        return new File(PATH_PREFIX + fileName);
    }

    /**
     * 通过路径读取内容为字符串
     * @param path
     * @return
     */
    public static String read(String path) {
        try {
            return FileUtils.readFileToString(new File(path), ENCODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过文件名写为文件
     * @param fileName
     * @param content
     */
    public static void write(String fileName, String content) {
        try {
            FileUtils.writeStringToFile(getFile(fileName), content, ENCODE);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 通过文件名将document写出为文件
     * @param fileName
     * @param document
     */
    public static void write(String fileName, Document document) {
        write(fileName, document, null);
    }

    /**
     * 通过文件名将document写出为文件并格式化为默认格式
     * @param fileName
     * @param content
     */
    public static void writeFormat(String fileName, String content) {
        Document document = Dom4jXmlUtils.stringToDocument(content);
        writeFormat(fileName, document);
    }

    /**
     * 通过文件名将document写出为文件并格式化为默认格式
     * @param fileName
     * @param document
     */
    public static void writeFormat(String fileName, Document document) {
        write(fileName, document, Dom4jXmlUtils.getDefaultOutputFormat(true));
    }

    /**
     * 通过文件名将document写出为文件并格式化为默认格式
     * @param fileName
     * @param document
     * @param isExpandEmptyElements 是否自闭和
     */
    public static void writeFormat(String fileName, Document document, boolean isExpandEmptyElements) {
        write(fileName, document, Dom4jXmlUtils.getDefaultOutputFormat(isExpandEmptyElements));
    }

    /**
     * 通过文件名将document写出为文件
     * @param fileName
     * @param document
     * @param format
     */
    public static void write(String fileName, Document document, OutputFormat format) {
        try (FileWriter fileWiter = new FileWriter(PATH_PREFIX + fileName)) {
            XMLWriter writer = null;
            if (format == null) {
                writer = new XMLWriter(fileWiter);
            } else {
                writer = new XMLWriter(fileWiter, format);
            }
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
