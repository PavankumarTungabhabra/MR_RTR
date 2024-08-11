package DataDrivenTesting.DataDrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil5 {
public static void main(String[] args) throws IOException {
	//create object for XSSFWorkbook
	FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//Get Access to sheets
	int NoOfSheets = workbook.getNumberOfSheets();
	for (int i = 0; i < NoOfSheets; i++) {
		if (workbook.getSheetName(i).equalsIgnoreCase("DataSheet1")) 
		{
			//access all the rows
			XSSFSheet sheet = workbook.getSheetAt(i);
			//Access all the rows
			Iterator<Row> Rows = sheet.iterator();
			Row FirstRow = Rows.next();
			Iterator<Cell> CellValue = FirstRow.cellIterator();
			int k=0;
			int column=0;
			while (CellValue.hasNext()) {
				Cell cell = CellValue.next();
				if (cell.getStringCellValue().equalsIgnoreCase("TestCase")) {
					column=k;
					
				}
				k++;
				
			}
			while (Rows.hasNext()) 
			{
				Row RowData = Rows.next();
				if (RowData.getCell(column).getStringCellValue().equalsIgnoreCase("STR")) {
					
				
				Iterator<Cell> CellData = RowData.cellIterator();
			while (CellData.hasNext()) {
				System.out.println(CellData.next().getStringCellValue());
					
				}
					
				}
			}
			}
			
		}
		
	}
	
}

