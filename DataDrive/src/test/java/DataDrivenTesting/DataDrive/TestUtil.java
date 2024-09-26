package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static void main(String[] args) throws IOException {
		//1. Create object for XSSFWorkbook
		FileInputStream fis=new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//2. Get Access to the Sheet
		int NumberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i <NumberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("DataSheet1")) {
				XSSFSheet XSheets = workbook.getSheetAt(i);
				//3. get access to all the row
				Iterator<Row> Rows = XSheets.iterator();
				Row FirstRow = Rows.next();
				Iterator<Cell> ce = FirstRow.cellIterator();
				int k=0;
				int column = 0;
				//4.  access to specific row
				while (ce.hasNext()) {
					Cell cell =  ce.next();
					if (cell.getStringCellValue().equalsIgnoreCase("TestCase")) 
					{
						column=k;
						
					}
					k++;
					
					
				}
				
				//5. access to all cell
				while (Rows.hasNext()) {
					Row r = Rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("STR"))
					{
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
					System.out.println(	cv.next().getStringCellValue());
							
							
						}
						
					} 
					
					
				}
				
			}
			
			
			
			
		}
		
		
	}

}
