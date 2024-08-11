package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil6 {
	public static void main(String[] args) throws IOException 
	//create object for XSSFWorkbook
	{
		FileInputStream fis= new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//Access all the sheets in excel
		int NoOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < NoOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("DataSheet1")) 
			{
				XSSFSheet Sheet = workbook.getSheetAt(i);
				//Get Access to all the rows
				Iterator<Row> Rows = Sheet.iterator();
				Row firstRow = Rows.next();
				Iterator<Cell> CellValue = firstRow.cellIterator();
				int k=0;
				int column=0;
				while (CellValue.hasNext()) {
					Cell data = CellValue.next();
					if (data.getStringCellValue().equalsIgnoreCase("TestCase")) {
						column=k;
						
					}
					k++;
				}
				while(Rows.hasNext())
				{
					Row RowData = Rows.next();
					if (RowData.getCell(column).getStringCellValue().equalsIgnoreCase("SPE"))
					{
						Iterator<Cell> CellData = RowData.cellIterator();
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
