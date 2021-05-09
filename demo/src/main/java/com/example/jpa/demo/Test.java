package com.example.jpa.demo;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\lichu\\Documents\\WeChat Files\\wxid_ztk8g2lz6jkj22\\FileStorage\\File\\2020-11\\附件1：2020年横县在校生信息表.xlsx");
        //byte[] bytes = FileUtils.readFileToByteArray();
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\lichu\\Documents\\WeChat Files\\wxid_ztk8g2lz6jkj22\\FileStorage\\File\\2020-11\\附件1：2020年横县在校生信息表.xlsx"));

        XSSFSheet sheet = wb.getSheet("高一1714");

        Map<String , List<XSSFRow>> clazzMap = new HashMap<>();
        for (int i = 4;i<sheet.getLastRowNum()+3;i++){
            XSSFRow row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            short lastCellNum = row.getLastCellNum();
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            if (clazzMap.get(row.getCell(5).getStringCellValue()) == null) {
                List<XSSFRow> objects = Lists.newArrayList();
                objects.add(row);
                clazzMap.put(row.getCell(5).getStringCellValue() , objects);
            } else {
                clazzMap.get(row.getCell(5).getStringCellValue()).add(row);
            }

//            for (int j = 0;j<lastCellNum;j++) {
//                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
//                System.out.println(row.getCell(j).getRichStringCellValue());
//            }

        }
        String parentPath = "D:\\Users\\class3";

        System.out.println(clazzMap.size());

        for (String key :clazzMap.keySet()) {
            String currnetPath = parentPath+"\\"+key+".xlsx";
            File childFold = new File(currnetPath);
            //建路径
            if (!childFold.exists()) {
                childFold.createNewFile();
            }
            List<XSSFRow> xssfRows = clazzMap.get(key);
            //
            XSSFWorkbook currnetBook = new XSSFWorkbook();
            XSSFSheet sheet1 = currnetBook.createSheet();
            int size = xssfRows.size();
            for (int k = 0;k< size ;k++) {
                XSSFRow row = sheet1.createRow(k);
                XSSFRow tempRow = xssfRows.get(k);
                int w = tempRow.getLastCellNum();
                for (int wt = 0;wt<w ;wt++) {
                    XSSFCell cell = row.createCell(wt);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    XSSFCell cell1 = tempRow.getCell(wt);
                    cell1.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(tempRow.getCell(wt).getStringCellValue());
                }
            }
            currnetBook.write(new FileOutputStream(childFold));
        }

        System.out.println(wb.getSheet("高二").getLastRowNum());
    }
}
