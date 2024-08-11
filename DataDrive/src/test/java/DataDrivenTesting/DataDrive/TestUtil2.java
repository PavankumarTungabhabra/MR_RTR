package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil2 {
	

	public static void main(String[] args) throws IOException {
		
	//Create XSSFWorkbook object
	FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
	XSSFWorkbook workBook=new XSSFWorkbook(fis);
	//GetAccess to Sheets
	int NumberOfSheets = workBook.getNumberOfSheets();
	for (int i = 0; i < NumberOfSheets; i++) 
	{
		if(workBook.getSheetName(i).equalsIgnoreCase("DataSheet1"))
		{
			XSSFSheet Sheets = workBook.getSheetAt(i);
			//Get Access to all the rows
			Iterator<Row> Rows = Sheets.iterator();
			Row FirstRow = Rows.next();
			FirstRow.cellIterator();
		}
		
	}
	
	
	}
}
