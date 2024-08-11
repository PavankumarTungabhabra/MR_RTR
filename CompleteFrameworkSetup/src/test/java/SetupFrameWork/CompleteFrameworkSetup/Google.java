package SetupFrameWork.CompleteFrameworkSetup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.MainPage;
import PageObjects.SubPage;
import TestComponents.BaseTest;
import frameWork.util.GptReader;
import frameWork.util.TestUtil;
import frameWork.util.Xls_Reader;

public class Google extends BaseTest {
	
	String path="C://Users//tunga//OneDrive//Desktop//DataDrivenTesting//DataSheet.xlsx";
	GptReader reader=new GptReader(path);
	@DataProvider
	public Iterator<Object[]> getData() throws FileNotFoundException, IOException {
		ArrayList<Object[]> testData = TestUtil.getTestData("NonSTR");
		return testData.iterator();
	}
	
	@Test(dataProvider = "getData")
	public void GoogleApplications(String TestCaseName,String Branch,String country,String location)
	{
		System.out.println(" "+TestCaseName+" "+Branch+" "+country+" "+location);
		SubPage subPage = mainPage.MainPageActions();
	}

}
