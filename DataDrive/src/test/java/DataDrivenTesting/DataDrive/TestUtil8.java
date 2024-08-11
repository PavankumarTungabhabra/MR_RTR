package DataDrivenTesting.DataDrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil8 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int NoOfSheets= workbook.getNumberOfSheets();
		for (int i = 0; i <NoOfSheets ; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("DataSheet1"))
			{
				XSSFSheet Sheet = workbook.getSheetAt(i);
				Iterator<Row> Row = Sheet.iterator();
				 org.apache.poi.ss.usermodel.Row FirstRow = Row.next();
				Iterator<Cell> CellValue = FirstRow.cellIterator();
				int k=0;
				int column=0;
				while (CellValue.hasNext()) {
					Cell cell = (Cell) CellValue.next();
					if(cell.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
						column=k;
					}
					k++;
				}
				while (Row.hasNext()) {
					org.apache.poi.ss.usermodel.Row ReqCell = Row.next();
					if (ReqCell.getCell(column).getStringCellValue().equalsIgnoreCase("STR"))
					{
						Iterator<Cell> CellData = ReqCell.cellIterator();
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
