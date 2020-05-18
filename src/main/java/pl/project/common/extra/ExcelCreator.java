package pl.project.common.extra;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelCreator<T> {
    private Class clazz;
    private static final String FILE_EXTENSION = ".xls";

    public ExcelCreator(Class clazz) {
        this.clazz = clazz;
    }

    public void createFile(List<T> series, String path, String fileName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {

        HSSFWorkbook excelFile = new HSSFWorkbook();

        HSSFSheet excelFileSheet = excelFile.createSheet(fileName);

        Font headerFont = excelFile.createFont();
        setFontAttributes(headerFont);

        CellStyle headerStyle = excelFile.createCellStyle();
        headerStyle.setFont(headerFont);

        List<String> columns = new ArrayList<>();

        for (Field f : clazz.getDeclaredFields()) {
            columns.add(f.getName());
        }

        Row headerRow = excelFileSheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns.get(i));
        }


        for (int i = 0; i < series.size(); i++) {
            HSSFRow row = excelFileSheet.createRow(i + 1);
            for (int j = 0; j < columns.size(); j++) {
                HSSFCell cell = row.createCell(j);

                Method method = series.get(i)
                        .getClass()
                        .getMethod("get" + columns.get(j)
                                .substring(0, 1).toUpperCase() + columns.get(j).substring(1));

                Object result = method.invoke(series.get(i));
                cell.setCellValue(String.valueOf(result));

            }
        }

        for (int i = 0; i < columns.size(); i++) {
            excelFileSheet.autoSizeColumn(i);
        }

        String file = path + fileName + FILE_EXTENSION;
        excelFile.write(new File(file));
        excelFile.close();
    }

    private void setFontAttributes(Font headerFont) {
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
    }
}