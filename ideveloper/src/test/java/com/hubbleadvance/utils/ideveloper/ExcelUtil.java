package com.hubbleadvance.utils.ideveloper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @description: POI 读取excel
 * @author: Ming.Lee/李明
 * @create: 2018-10-13 13:34
 **/
public class ExcelUtil {

    /**
     * 验证EXCEL文件是否合法
     * @param filePath
     * @return
     */
    public static boolean validateExcel(String filePath) {
        /** 判断文件名是否为空或者文件是否存在 */
        if (!fileExist(filePath)) {
            err("文件不存在");
            return false;
        }

        /** 检查文件是否是Excel格式的文件 */
        if (!isExcel(filePath)) {
            err("文件名不是excel格式");
            return false;
        }

        return isExcel2007(filePath);
    }
    /**
     * 检查文件是否存在
     */
    public static boolean fileExist(String filePath){
        if(filePath == null || filePath.trim().equals("")) return false;
        File file = new File(filePath);
        if (file == null || !file.exists()){
            return false;
        }
        return true;
    }
    /**
     * 依据后缀名判断读取的是否为Excel文件
     *
     * @param filePath
     * @return
     */
    public static  boolean isExcel(String filePath) {
        if (filePath.matches("^.+\\.(?i)(xls)$")
                || filePath.matches("^.+\\.(?i)(xlsx)$")) {
            return true;
        }
        return false;
    }


    /***
     * 读取2007-2013格式
     * @param filePath 文件路径
     * @return
     * @throws IOException
     * @DataTime 2016年10月13日18:01:02
     */
    @SuppressWarnings("rawtypes")
    public static List<Map> readExcel2007(String filePath) throws IOException{
        List<Map> valueList=new ArrayList<Map>();
        FileInputStream fis =null;
        try {
            fis =new FileInputStream(filePath);
            XSSFWorkbook xwb = new XSSFWorkbook(fis);               // 构造 XSSFWorkbook 对象，strPath 传入文件路径
            XSSFSheet sheet = xwb.getSheetAt(0);                // 读取第一章表格内容
            // 定义 row、cell
            XSSFRow row;
            // 循环输出表格中的第一行内容表头
            Map<Integer, String> keys=new HashMap<Integer, String>();
            row = sheet.getRow(0);
            if(row !=null){
                //System.out.println("j = row.getFirstCellNum()::"+row.getFirstCellNum());
                //System.out.println("row.getPhysicalNumberOfCells()::"+row.getPhysicalNumberOfCells());
                for (int j = row.getFirstCellNum(); j <=row.getPhysicalNumberOfCells(); j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    if(row.getCell(j)!=null){
                        if(!row.getCell(j).toString().isEmpty()){
                            keys.put(j, row.getCell(j).toString());
                        }
                    }else{
                        keys.put(j, "K-R1C"+j+"E");
                    }
                }
            }
            // 循环输出表格中的从第二行开始内容
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    boolean isValidRow = false;
                    Map<String, Object> val = new HashMap<String, Object>();
                    for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell != null) {
                            String cellValue = null;
                            if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
                                if(DateUtil.isCellDateFormatted(cell)){
                                    cellValue = new DataFormatter().formatRawCellContents(cell.getNumericCellValue(), 0, "yyyy-MM-dd HH:mm:ss");
                                }
                                else{
                                    cellValue = String.valueOf(cell.getNumericCellValue());
                                }
                            }
                            else{
                                cellValue = cell.toString();
                            }
                            if(cellValue!=null&&cellValue.trim().length()<=0){
                                cellValue=null;
                            }
                            val.put(keys.get(j), cellValue);
                            if(!isValidRow && cellValue!= null && cellValue.trim().length()>0){
                                isValidRow = true;
                            }
                        }
                    }

                    // 第I行所有的列数据读取完毕，放入valuelist
                    if (isValidRow) {
                        valueList.add(val);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fis.close();
        }
        return valueList;
    }
    /**读取老版本格式*/
    public static List<Map> readExcelXls(String filePath){

        return null;
    };
    /**
     * 依据内容判断是否为excel2007及以上
     */
    public static  boolean isExcel2007(String filePath) {
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(filePath));
            if (POIXMLDocument.hasOOXMLHeader(bis)) {
                System.out.println("Excel版本为excel2007及以上");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private static void log(String value){
        System.out.println(value);
    }
    private static void err(String value){
        System.err.println(value);
    }
}

