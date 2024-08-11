package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil3 {
public static void main(String[] args) throws IOException {
	//Create object for XSSFWorkbook
	FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
	XSSFWorkbook workBook= new XSSFWorkbook(fis);
	//Get Access to Sheet
	int NoOfSheets = workBook.getNumberOfSheets();
	for (int i = 0; i < NoOfSheets; i++) {
		if(workBook.getSheetName(i).equalsIgnoreCase("DataSheet1"))
		{
			XSSFSheet Sheet = workBook.getSheetAt(i);
			Iterator<Row> Rows = Sheet.iterator();
			Row FirstRow = Rows.next();
			Iterator<Cell> cellValue = FirstRow.cellIterator();
			int k=0;
			int column=0;
			while (cellValue.hasNext()) {
				Cell cell = (Cell) cellValue.next();
				if(cell.getStringCellValue().equalsIgnoreCase("TestCase"))
				{
					column=k;
				}
				k++;
				
			}
			while (Rows.hasNext()) {
				Row rowData =  Rows.next();
				if (rowData.getCell(column).getStringCellValue().equalsIgnoreCase("STR")) 
				{
					Iterator<Cell> cellData = rowData.cellIterator();
					while (cellData.hasNext()) {
						System.out.println(cellData.next().getStringCellValue());
						
						
						
					}
				}
				
			}
			
		}
		
	}
}
}
