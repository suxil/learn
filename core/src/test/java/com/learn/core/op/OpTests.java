package com.learn.core.op;

import com.learn.core.util.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/10/2 0002 7:57
 */
@Slf4j
public class OpTests {

    private String basePath = "F:\\娱乐视频";
    private String oldDir = "海贼王";
    private String newDir = "海贼王new";
    private String mp4Dir = "海贼王mp4";

    private File getFile(String dir) {
        Path path = Paths.get(basePath, dir);

        File file = path.toFile();
        return file;
    }

    @Test
    public void createDir() {
        File file = getFile(oldDir);

        for (File d : file.listFiles()) {
            if (d.isDirectory()) {
                System.out.print("-- " + d.getName());
                writePath(d.getName());
            }
        }

        System.out.println("-- create directory done.");
    }

    /**
     * 创建目录
     * @param pathName
     */
    private void writePath(String pathName) {
        try {
            Path path = Paths.get(basePath + "\\" + newDir, pathName);
            if (Files.exists(path)) {
                System.out.println(" -- 已存在.");
            } else {
                Files.createDirectory(path);
                System.out.println();
            }
        } catch (IOException e) {
            log.error("writePath: " + e.getMessage());
        }
    }

    @Test
    public void renameFile() {
        Map<String, Map<String, File>> map = new HashMap<>();

        Map<Integer, Info> infoMap = getAllInfo();

        String formatStr = "[AGE][ONE.PIECE][%s][%s][720P][CHS].mp4";

        DecimalFormat df = new DecimalFormat("0000");
        File file = getFile(mp4Dir);
        for (File f : file.listFiles()) {
            if (!f.isDirectory()) {
                int seq = getSeq(f.getName());

                Info info = infoMap.get(seq);
                String fileName = String.format(formatStr, df.format(seq), info.getName());

                String newFileName = basePath + "\\" + mp4Dir + "\\" + fileName;

                newFileName = newFileName.replace("?", "？");

                File newFile = new File(newFileName);

                if (!f.renameTo(newFile)) {
                    log.warn("renameFile");
                }
            }
        }

        System.out.println("-- rename all file done.");
    }

    private int getSeq(String name) {
        Pattern pattern = Pattern.compile("\\[AGE\\]\\[ONE.PIECE_(\\d+)\\]\\[720P\\]\\[CHS\\].mp4");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            String seq = matcher.group(1);
            if (StringUtils.isNotEmpty(seq)) {
                return Integer.parseInt(seq);
            }
        }
        return 0;
    }

    /**
     * 获取所有集标题
     * @return
     */
    private Map<Integer, Info> getAllInfo() {
        Map<Integer, Info> map = new HashMap<>();

        String dirPath = "F:\\娱乐视频\\海贼王-目录-850.html";
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(dirPath)));
        } catch (IOException e) {
            log.error("getAllInfo: " + e.getMessage());
        }
        Document document = Jsoup.parse(content);
        Elements ulElements = document.select("ul");
        ulElements.forEach(ulElement -> {
            Elements liElements = ulElement.select("li");
            liElements.forEach(liElement -> {
                Elements aElements = liElement.select("div.site-piclist_info a");

                String seq = aElements.get(0).attr("title");
                String name = aElements.get(1).attr("title");

                Info info = new Info();
                info.setSeq(Integer.parseInt(seq));
                info.setName(name);

                map.put(info.getSeq(), info);
            });
        });

        return map;
    }

    @Data
    private class Info {
        private int seq;
        private String name;
    }

}
