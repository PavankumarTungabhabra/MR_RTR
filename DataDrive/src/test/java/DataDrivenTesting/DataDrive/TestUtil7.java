package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil7 {
public static void main(String[] args) throws IOException {
	FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	//get access to specific sheet
	int NoOfSheets = workbook.getNumberOfSheets();
	for (int i = 0; i < NoOfSheets; i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("Datasheet1"))
		{
			XSSFSheet Sheet = workbook.getSheetAt(i);
			//get access to rows
			Iterator<Row> Rows = Sheet.iterator();
			Row FirstRow = Rows.next();
			//get access to column
			Iterator<Cell> Cell = FirstRow.cellIterator();
			int k=0;
			int column=0;
			while (Cell.hasNext()) {
				Cell CellData = (Cell) Cell.next();
				if (CellData.getStringCellValue().equalsIgnoreCase("Testcase")) {
					column=k;
					
				}
				k++;
				
			}
			//access specific cell bu scanning the specific data
			while (Rows.hasNext()) {
				Row Rowvalue = Rows.next();
				if (Rowvalue.getCell(column).getStringCellValue().equalsIgnoreCase("STR")) 
				{
					Iterator<org.apache.poi.ss.usermodel.Cell> CellValue = Rowvalue.cellIterator();
					while (CellValue.hasNext()) {
						org.apache.poi.ss.usermodel.Cell CellReqData = CellValue.next();
						System.out.println(CellReqData.getStringCellValue());
						
					}
				}
			}
		}
		
		
	}
}
}
