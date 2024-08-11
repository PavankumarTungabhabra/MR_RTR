package frameWork.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GptReader {
	private static Workbook workbook;
	private static FileInputStream fis;
	private static Sheet sheet;
	private static Row row;
	private Cell cell;
	private static String path;
	
	public GptReader(String path)
	{
		this.path=path;
	}
	
public static String getCellData(String sheetName,String columnName,int rowNum) throws FileNotFoundException, IOException
{
	try (FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis)) {

           // Get the sheet by name
           Sheet sheet = workbook.getSheet(sheetName);
           if (sheet == null) {
               throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
           }

           // Convert column name to index
           int columnIndex = getColumnIndex(columnName);
           if (columnIndex == -1)
           {
               throw new IllegalArgumentException("Invalid column name " + columnName);
           }

           // Get the row (0-based index)
           Row row = sheet.getRow(rowNum - 1);
           if (row == null) {
               throw new IllegalArgumentException("Row number " + rowNum + " does not exist.");
           }

           // Get the cell
           Cell cell = row.getCell(columnIndex);
           if (cell == null) {
               return "Cell is empty.";
           } else {
               // Return the cell value based on its type
               switch (cell.getCellType()) {
                   case STRING:
                       return cell.getStringCellValue();
                   case NUMERIC:
                       if (DateUtil.isCellDateFormatted(cell)) {
                           return cell.getDateCellValue().toString();
                       } else {
                           return Double.toString(cell.getNumericCellValue());
                       }
                   case BOOLEAN:
                       return Boolean.toString(cell.getBooleanCellValue());
                   case FORMULA:
                       return cell.getCellFormula();
                   case BLANK:
                       return "Cell is blank.";
                   default:
                       return "Cell type is not recognized.";
               }
           }
}
}

public static int getColumnIndex(String columnName) {
    int columnIndex = 0;
    for (int i = 0; i < columnName.length(); i++) {
        columnIndex = (columnIndex + 1) * 26 + (columnName.charAt(i) - 'A');
    }
    return columnIndex;
}
}

