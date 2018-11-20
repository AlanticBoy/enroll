package com.enroll.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  11:07 2018/6/709
 * @ModefiedBy:
 */
public class ExcelWithoutResponse {

    private final static String TEMPLATE_PATH = "E:\\enroll_template.xlsx";
    public static String orders[] = {"name","segment","entainment","phone"};
    public static String enroll_order[]={"Java_group","前端_group","C#_group","Python_group"};
    public static void ExportNoResponse(Map<Integer, List<Map<String, String>>> allMap_) throws Exception {
                  /*导出模版路径*/
        String filePath = "";
        for (int i = 0; i < allMap_.size(); i++) {
            System.out.println(" whose size is  " + allMap_.size() + " is executing current loop " + i);
            filePath = "E:\\enrollment\\" + enroll_order[i] + ".xlsx";
            XSSFWorkbook workbook = null;
            try {
                workbook = new XSSFWorkbook(TEMPLATE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 获取sheet页
            XSSFSheet sheet = workbook.getSheetAt(0);
            // 行
            XSSFRow row = null;
            // 行下标
            int rowNum = 1;
           /*遍历查询结果*/
            List<Map<String, String>> mapList = allMap_.get(i);
            System.out.println("  has records  " + mapList.size());
            for (int n = 0; n < mapList.size(); n++) {
                Map<String, String> map = mapList.get(n);
                 /*定义列下标*/
                int cellNum = 0;
                row = sheet.createRow(rowNum++);
                row.createCell(cellNum++).setCellValue(n+1);
                for (int order = 0; order < orders.length; order++) {
                    row.createCell(cellNum++).setCellValue(map.get(orders[order]));
                }
            }
            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // 第六步，将文件存到指定位置
            try {
                workbook.write(fout);
                System.out.println(" export success ");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" export failure ");
            } finally {
                fout.close();
            }
        }
    }

}
