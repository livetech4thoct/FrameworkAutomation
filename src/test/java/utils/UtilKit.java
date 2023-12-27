package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	public static FileInputStream fis1;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	
	public static HashMap<String,String> getTestData(String testCaseName) 
	{
		
		try {
			fis1=new FileInputStream("src\\test\\resources\\testdata\\excels\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb=new XSSFWorkbook(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ws=wb.getSheet("testdata");
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws,testCaseName);
		
		HashMap<String, String> testDataMap=new HashMap<String, String>();
		
		for(int i=0;i<testCaseRows.size();i++)
		{
			
			for(int j=1;j<testCaseRows.get(0).getLastCellNum();j++)
			{
			testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
			}
			
		}
		
		return testDataMap;
		
		
	}

	static ArrayList<Row> getTestCaseRows(XSSFSheet ws,String testCaseName) {
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
		}
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0) != null)
			{
				if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
					testCaseRows.add(allRows.get(i));
				}
			}
		}
		
		return testCaseRows;
		
	}

}
