package com.learn.core.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/3 0003 12:02
 */
public class ExcelUtilsTest {

    @Test
    public void test() throws Exception {

        String basePath = "F:\\work-content\\工作量统计\\"; // 工作量xsl目录
        String tempPath = basePath + "工作记录-模板.xls"; // 模板文件

        File file = new File(basePath);
        File[] files = file.listFiles((dir, name) -> {
            if (name.indexOf("ED的工作记录") < 0) {
                return false;
            }
            return true;
        });

        for (File f : files) {
            analysis(basePath + f.getName(), basePath + f.getName().replace(".xls", "-new.xls"), tempPath);
        }

    }

    public static void analysis(String filePath, String outPath, String tempPath) throws Exception {
        List<String> names = Arrays.asList("郭照军", "卢小强", "曹俊涛", "张亚辉", "薛家兴");
        Map<String, List<List<String>>> map = new HashMap<>();

        Workbook wb = readFile(filePath);
        Sheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            int cellCount = row.getLastCellNum();
            if (cellCount != 7) {
                continue;
            }

            String name = getCellValue(row.getCell(5));
            if (!names.contains(name)) {
                continue;
            }

            List<String> record = new ArrayList<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                String value = getCellValue(cell);
                record.add(value);
            }

            if (map.containsKey(name)) {
                map.get(name).add(record);
            } else {
                List<List<String>> rowList = new ArrayList<>();
                rowList.add(record);
                map.put(name, rowList);
            }
        }

        FileOutputStream fos = new FileOutputStream(outPath);
        Workbook outWb = readFile(tempPath);
        Sheet sheetOut = outWb.getSheetAt(0);
        int outIdx = 2;
        for (Map.Entry<String, List<List<String>>> entry : map.entrySet()) {
            String name = entry.getKey();
            for (List<String> record : entry.getValue()) {
                Row row = sheetOut.createRow(outIdx++);
                for (int i = 0; i < record.size(); i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(record.get(i));
                }
            }
            sheetOut.createRow(outIdx++);
        }

        outWb.write(fos);

        outWb.close();
        wb.close();
    }

    /**
     * 通过文件路径读取xsl文件
     *
     * @param filePath
     * @return
     */
    public static HSSFWorkbook readFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过cell获取当前列的值，转换成字符串
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String value = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case FORMULA:
                    value = cell.getCellFormula();
                    break;
                case NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case BLANK:
                    value = "";
                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case ERROR:
                    value = String.valueOf(cell.getErrorCellValue());
                    break;
                default:
                    value = cell.getCellTypeEnum().name();
            }
        }
        return value;
    }

}
