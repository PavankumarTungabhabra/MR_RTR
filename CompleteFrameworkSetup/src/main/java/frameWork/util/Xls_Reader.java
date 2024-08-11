package frameWork.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xls_Reader {
	private static Workbook workbook;
	private static FileInputStream fis;
	private static Sheet sheet;
	private static Row row;
	private Cell cell;
	private static String path;
	
	public Xls_Reader(String path)
	{
		this.path=path;
	}
	
public static String getCellData(String SheetName,String columnName,int rowNum)
{
	
	try {
		fis=new FileInputStream(path);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(SheetName);
	Row rowHeader = sheet.getRow(0);
	int columIdx=-1;
	for (Cell cell : rowHeader) {
		if (cell.getStringCellValue().equals(columnName)) {
			columIdx=cell.getColumnIndex();
			break;
			
		}
		if (columIdx==-1) {
			return"column is fault";
			
		}
		row=sheet.getRow(rowNum-1);
		if (row==null) {
			return"row is fault";
			
		}
		cell=row.getCell(columIdx);
		if (cell==null) {
			return "cell is fault";
			
		}
		else {
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
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "ERROR";
}
}
