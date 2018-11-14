package com.learn.core.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/3 0003 11:24
 */
public class ExcelUtils {

    /**
     * 通过文件路径读取xsl文件
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
