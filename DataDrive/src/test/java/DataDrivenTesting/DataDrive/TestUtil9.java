package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil9 {
public static void main(String[] args) throws IOException {
	FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int NoOfSheets = workbook.getNumberOfSheets();
	for (int i = 0; i < NoOfSheets; i++) {
		if (workbook.getSheetName(i).equalsIgnoreCase("DataSheet1")) 
		{
			XSSFSheet Sheet = workbook.getSheetAt(i);
			Iterator<Row> Rows = Sheet.iterator();
			Row FirstRow = Rows.next();
			Iterator<Cell> RowCell = FirstRow.cellIterator();
			int k=0;
			int column=0;
			while(RowCell.hasNext())
			{
				Cell CellValue = RowCell.next();
				if (CellValue.getStringCellValue().equalsIgnoreCase("TestCase")) {
					column=k;
					
				}
				k++;
			}
			while (Rows.hasNext()) {
				 Row ReqCellRow = Rows.next();
				if (ReqCellRow.getCell(column).getStringCellValue().equalsIgnoreCase("STR")) 
				{
				Iterator<Cell> CellData = ReqCellRow.cellIterator();	
				while (CellData.hasNext()) {
					Cell cell = (Cell) CellData.next();
					System.out.println(cell.getStringCellValue());
					
				}
				}
				
			}
		}
		
	}
	
}
}
