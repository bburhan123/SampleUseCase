package framework_utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

    private static Workbook excelWorkbook;
    private static Sheet excelSheet;

    public static void getExcelSheet(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        excelWorkbook = WorkbookFactory.create(fis);
        excelSheet = excelWorkbook.getSheetAt(0);
        fis.close();
    }

    public static void writeCellData(String filePath, int rowIndex, int colIndex, String data) throws Exception {
        if (excelWorkbook == null)
            getExcelSheet(filePath);
        Row row = excelSheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            cell = row.createCell(colIndex);
        }
        cell.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(filePath);
        excelWorkbook.write(fos);
        fos.close();
    }
}
