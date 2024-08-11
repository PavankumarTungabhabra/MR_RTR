package frameWork.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.formula.atp.Switch;

import com.aventstack.extentreports.model.Test;

public class TestUtil {
static String path="C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx";
static GptReader reader;
public static ArrayList<Object[]> getTestData(String TestCase) throws FileNotFoundException, IOException
{
	ArrayList<Object[]> myData=new ArrayList<Object[]>();
	try {
		reader=new GptReader(path);
	} catch (Exception e) {
		// TODO: handle exception
	}
	int rowNum=2;
	switch(TestCase)
	{
	case"SPE":
		rowNum=2;
	break;
	case "NonSPE":
		rowNum=3;
		break;
	case "NonSTR":
		rowNum=4;
		break;
	case "STR":
		rowNum=5;
		break;
	case "BOLI":
		rowNum=6;
		break;
	case "FED":
		rowNum=7;
		break;
		default:
		break;
	}
		//int rowNo=Integer.parseInt(reader.getCellData("DataSheet1", "RowNumber", rowNum));
		String TestCaseName=reader.getCellData("DataSheet1", "TestCase", rowNum);
		String Branch=reader.getCellData("DataSheet1", "Branch", rowNum);
		String country=reader.getCellData("DataSheet1", "Country", rowNum);
		String location=reader.getCellData("DataSheet1", "Location", rowNum);
		Object[] ob={TestCaseName,Branch,country,location};
		myData.add(ob);
		return myData;
	
}
}
